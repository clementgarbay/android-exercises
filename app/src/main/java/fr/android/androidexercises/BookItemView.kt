package fr.android.androidexercises

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView

class BookItemView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : LinearLayout(context, attrs, defStyleAttr), ItemView<Book> {

    private var nameTextView: TextView? = null
    private var priceTextView: TextView? = null

    override fun onFinishInflate() {
        super.onFinishInflate()

        nameTextView = findViewById(R.id.nameTextView)
        priceTextView = findViewById(R.id.priceTextView)
    }

    override fun bind(element: Book) {
        nameTextView?.text = element.name
        priceTextView?.text = element.price.toString()
    }
}