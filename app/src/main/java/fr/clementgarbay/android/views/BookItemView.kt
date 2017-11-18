package fr.clementgarbay.android.views

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import fr.clementgarbay.android.models.Book
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