package fr.clementgarbay.android.book.infrastructure.controller

import android.content.res.Configuration
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import fr.clementgarbay.android.R
import fr.clementgarbay.android.book.domain.model.Book
import fr.clementgarbay.android.book.infrastructure.ui.BookDetailsFragment
import fr.clementgarbay.android.book.infrastructure.ui.BookDetailsFragment.Companion.BOOK_KEY
import fr.clementgarbay.android.book.infrastructure.ui.BookListFragment
import fr.clementgarbay.android.generic.ui.handler.ItemClickedListener
import timber.log.Timber

/**
 * @author Clément Garbay <contact@clementgarbay.fr>
 */
class LibraryActivity : AppCompatActivity(), ItemClickedListener<Book> {

    private var selectedBook: Book? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)

        // Plant logger cf. Android Timber
        Timber.plant(Timber.DebugTree())

        // Init screen with book list fragment
        supportFragmentManager.beginTransaction()
                .replace(R.id.containerFrameLayout, BookListFragment(), BookListFragment::class.java.simpleName)
                .commit()

        // If there is a saved state of book, select it
        if (savedInstanceState?.containsKey(BOOK_KEY) == true) {
            selectBook(savedInstanceState.getParcelable(BOOK_KEY))
        }
    }

    override fun onItemClicked(item: Book) = selectBook(item)

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(BOOK_KEY, selectedBook) // save selected book in state
    }

    private fun selectBook(item: Book) {
        selectedBook = item
        displayBookDetailsFragment()
    }

    private fun displayBookDetailsFragment() {
        // On portrait mode, show book details in the main container frame layout
        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.containerFrameLayout, createBookDetailsFragment(), BookDetailsFragment::class.java.simpleName)
                    .addToBackStack("fromBookListToBookDetails")
                    .commit()
        }

        // On landscape mode, show book details in the right details frame layout
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.detailsFrameLayout, createBookDetailsFragment(), BookDetailsFragment::class.java.simpleName)
                    .commit()
        }
    }

    private fun createBookDetailsFragment(): BookDetailsFragment {
        val bookDetailsFragment = BookDetailsFragment()
        val bundle = Bundle()
        bundle.putParcelable(BOOK_KEY, selectedBook)
        bookDetailsFragment.arguments = bundle // put selected book in fragment argument
        return bookDetailsFragment
    }
}
