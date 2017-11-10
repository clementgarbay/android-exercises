package fr.android.androidexercises

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import java.util.*
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

class LibraryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)

        val recyclerView = findViewById<RecyclerView>(R.id.bookListView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = AdapterRecycler(this, getBooks())

        startService(Intent(this, JobService::class.java))
    }

    private fun getBooks(): List<Book> = (0..99).map {
        Book("Garry Potier Tome $it", Random().nextInt(30))
    }
}
