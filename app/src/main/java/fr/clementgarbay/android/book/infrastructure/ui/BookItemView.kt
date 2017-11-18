package fr.clementgarbay.android.book.infrastructure.ui

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import fr.clementgarbay.android.book.domain.model.Book
import fr.clementgarbay.android.generic.ui.BindableView
import kotlinx.android.synthetic.main.book_item_view.view.*

/**
 * @author Clément Garbay <contact@clementgarbay.fr>
 */
class BookItemView : LinearLayout, BindableView<Book> {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun bind(item: Book): View {
        item_titleTextView?.text = item.title
        Glide.with(this).load(item.cover).into(item_coverImageView)
        return this
    }
}