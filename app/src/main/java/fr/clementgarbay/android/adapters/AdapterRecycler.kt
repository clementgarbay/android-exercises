package fr.clementgarbay.android.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fr.clementgarbay.android.R
import fr.clementgarbay.android.listeners.OnItemClickedListener
import fr.clementgarbay.android.views.BindableView

/**
 * @author Clément Garbay <contact@clementgarbay.fr>
 */
class AdapterRecycler<T>(
        private val inflater: LayoutInflater,
        private val items: List<T>,
        private val listener: OnItemClickedListener<T>
) : RecyclerView.Adapter<AdapterRecycler<T>.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.book_item_view, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        (holder.itemView as BindableView<T>)
            .bind(item) // fill view from item
            .setOnClickListener { listener.onItemClicked(item) } // add a click listener on each item view
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}