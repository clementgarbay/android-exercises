package fr.clementgarbay.android.fragments

import android.content.Context
import android.os.Bundle
import android.os.Parcelable
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import fr.clementgarbay.android.R
import fr.clementgarbay.android.adapters.AdapterRecycler
import fr.clementgarbay.android.adapters.BookAdapterRecycler
import fr.clementgarbay.android.listeners.OnItemClickedListener
import fr.clementgarbay.android.models.Book
import fr.clementgarbay.android.services.BooksApi

/**
 * @author Clément Garbay <contact@clementgarbay.fr>
 */
class ListFragment<T : Parcelable> : Fragment() {

    private var items: ArrayList<T> = ArrayList()
    private lateinit var adapter: AdapterRecycler<T>
    private lateinit var listener: OnItemClickedListener<T>

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnItemClickedListener<T> // TODO: unchecked cast
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(this.arguments.getInt(FRAGMENT_RESOURCE_KEY), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Init book adapter recycler
        adapter = AdapterRecycler(LayoutInflater.from(view.context), items, listener)

        // Init recycler view
        val recyclerView = view.findViewById<RecyclerView>(this.arguments.getInt(RECYCLER_RESOURCE_KEY))
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.adapter = adapter

        // Check if there is a saved state of items
        if (savedInstanceState != null) {
            refreshList(savedInstanceState.getParcelableArrayList(ITEMS_KEY))
        } else { // Otherwise, use the items from the fragment arguments
            refreshList(this.arguments.getParcelableArrayList(ITEMS_KEY))
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelableArrayList(ITEMS_KEY, ArrayList(items)) // save items in state
    }

    private fun refreshList(newItems: List<T>) {
        items.clear()
        items.addAll(newItems)
        adapter.notifyDataSetChanged()
    }

    companion object {
        private val ITEMS_KEY = "items"
        private val FRAGMENT_RESOURCE_KEY = "resource_fragment"
        private val RECYCLER_RESOURCE_KEY = "resource_recycler"

        fun <T : Parcelable> create(
                fragmentResource : Int,
                recyclerResource : Int,
                items : ArrayList<T>
        ) : ListFragment<T> {
            val listFragment = ListFragment<T>()
            val bundle = Bundle()
            bundle.putInt(FRAGMENT_RESOURCE_KEY, fragmentResource)
            bundle.putInt(RECYCLER_RESOURCE_KEY, recyclerResource)
            bundle.putParcelableArrayList(ITEMS_KEY, items)
            listFragment.arguments = bundle
            return listFragment
        }
    }
}