package fr.clementgarbay.android.fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import fr.clementgarbay.android.R
import fr.clementgarbay.android.adapters.AdapterRecycler
import fr.clementgarbay.android.listeners.OnItemClickedListener
import fr.clementgarbay.android.models.Book
import fr.clementgarbay.android.services.BooksApi

/**
 * @author Clément Garbay <contact@clementgarbay.fr>
 */
class BookListFragment : Fragment() {

    private var books: ArrayList<Book> = ArrayList()
    private lateinit var adapter: AdapterRecycler<Book>
    private lateinit var listener: OnItemClickedListener<Book>

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnItemClickedListener<Book> // TODO: unchecked cast
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.book_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Init book adapter recycler
        adapter = AdapterRecycler(LayoutInflater.from(view.context), books, listener)

        // Init recycler view
        val recyclerView = view.findViewById<RecyclerView>(R.id.bookListView)
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.adapter = adapter

        // Check if there is a saved state of books
        if (savedInstanceState != null) {
            refreshBookList(savedInstanceState.getParcelableArrayList(BOOKS_KEY))
        } else { // Otherwise, fetch books from API
            BooksApi.getBooks({ books ->
                refreshBookList(books)
            }, {
                Toast.makeText(context, R.string.fetch_books_failure, Toast.LENGTH_LONG).show()
            })
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelableArrayList(BOOKS_KEY, ArrayList(books)) // save books in state
    }

    private fun refreshBookList(newBooks: List<Book>) {
        books.clear()
        books.addAll(newBooks)
        adapter.notifyDataSetChanged()
    }

    companion object {
        private val BOOKS_KEY = "books"
    }
}