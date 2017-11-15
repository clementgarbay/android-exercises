package fr.clementgarbay.android.views

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import fr.clementgarbay.android.models.Book
import kotlinx.android.synthetic.main.book_item_view.view.*

/**
 * @author Clément Garbay <contact@clementgarbay.fr>
 */
class BookItemView : LinearLayout {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    fun bindView(book: Book): BookItemView {
        item_titleTextView?.text = book.title
        Glide.with(this).load(book.cover).into(item_coverImageView)
        return this
    }
}