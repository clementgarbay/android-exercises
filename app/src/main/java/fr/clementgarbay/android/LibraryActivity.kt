package fr.clementgarbay.android

import android.content.res.Configuration
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import fr.clementgarbay.android.fragments.BookDetailsFragment
import fr.clementgarbay.android.fragments.BookDetailsFragment.Companion.BOOK_KEY
import fr.clementgarbay.android.fragments.BookListFragment
import fr.clementgarbay.android.fragments.ListFragment
import fr.clementgarbay.android.listeners.OnItemClickedListener
import fr.clementgarbay.android.models.Book
import fr.clementgarbay.android.services.BooksApi
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

        BooksApi.getBooks({ books ->
            // Init screen with book list fragment
            ListFragment.create<Book>(R.layout.book_list_fragment, R.id.bookListView, ArrayList(books))
        }, {
            Toast.makeText(this, "An error occurred when trying to retrieve books.", Toast.LENGTH_LONG).show()
        })
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
        bookDetailsFragment.arguments = bundle // put selected book in fragment argument
        return bookDetailsFragment
    }
}
