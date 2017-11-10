package fr.android.androidexercises

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.custom_view_item_book.view.*

class BookItemView : LinearLayout, ItemView<Book> {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun bind(element: Book) {
        nameTextView?.text = element.name
        priceTextView?.text = element.price.toString()
    }
}