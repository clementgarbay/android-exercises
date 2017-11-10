package fr.android.androidexercises

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class AdapterRecycler<T>(context: Context, private val elements: List<T>) : RecyclerView.Adapter<AdapterRecycler<T>.MyViewHolder>() {
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(inflater.inflate(R.layout.custom_view_item_book, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        (holder.itemView as ItemView<T>).bind(elements[position])
    }

    override fun getItemCount(): Int = elements.size

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}