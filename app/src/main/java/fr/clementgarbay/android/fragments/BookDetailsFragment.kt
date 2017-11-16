package fr.clementgarbay.android.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import fr.clementgarbay.android.R
import fr.clementgarbay.android.models.Book
import kotlinx.android.synthetic.main.book_details_fragment.*

/**
 * @author Clément Garbay <contact@clementgarbay.fr>
 */
class BookDetailsFragment : Fragment() {

    private var book: Book? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.book_details_fragment, container, false)
        book = this.arguments.getParcelable(BOOK_KEY) // retrieve book from fragment argument
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        book?.let {
            details_titleTextView?.text = it.title
            details_priceTextView?.text = it.price
            details_isbnTextView?.text = it.isbn
            Glide.with(this).load(it.cover).into(details_coverImageView)
        }
    }

    companion object {
        val BOOK_KEY = "book"
    }
}