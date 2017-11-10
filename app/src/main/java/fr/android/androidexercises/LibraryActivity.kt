package fr.android.androidexercises

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import java.util.*
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

class LibraryActivity : AppCompatActivity() {

    private val RANDOM = Random()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar

        val messageTextView = findViewById<View>(R.id.messageTextView) as TextView
        messageTextView.setText(R.string.welcome) // ou messageTextView.text = ''

        val books = getBooks()

        val recyclerView = findViewById<RecyclerView>(R.id.bookListView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = AdapterRecycler(this, books)

        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_library, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        return if (id == R.id.action_settings) true else super.onOptionsItemSelected(item)
    }

    private fun getBooks(): List<Book> {
        return (0..99).map {
            Book("Garry Potier Tome $it", RANDOM.nextInt(30))
        }
    }
}
