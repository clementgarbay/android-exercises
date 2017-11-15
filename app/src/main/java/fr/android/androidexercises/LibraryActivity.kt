package fr.android.androidexercises

import android.content.res.Configuration
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import fr.android.androidexercises.fragments.BookDetailsFragment
import fr.android.androidexercises.fragments.BookDetailsFragment.Companion.BOOK_KEY
import fr.android.androidexercises.fragments.BookListFragment
import fr.android.androidexercises.listeners.OnItemClickedListener
import fr.android.androidexercises.models.Book
import timber.log.Timber

/**
 * @author Clément Garbay <contact@clementgarbay.fr>
 */
class LibraryActivity : AppCompatActivity(), OnItemClickedListener<Book> {

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
    }

    override fun onItemClicked(item: Book) {
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
        bookDetailsFragment.arguments = bundle
        return bookDetailsFragment
    }
}
