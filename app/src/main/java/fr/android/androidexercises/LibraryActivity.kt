package fr.android.androidexercises

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ListView

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber

class LibraryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)

        val bookList = findViewById<ListView>(R.id.bookListView)

        // Plant logger cf. Android Timber
        Timber.plant(Timber.DebugTree())

        // Build Retrofit
        val retrofit = Retrofit.Builder()
                .baseUrl("http://henri-potier.xebia.fr/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        // Create a service
        val service = retrofit.create(HenriPotierService::class.java)

        // Enqueue call and display book title
        service.listBooks().enqueue(object : Callback<List<Book>> {
            override fun onResponse(call: Call<List<Book>>, response: Response<List<Book>>) {
                val books = response.body()

                // log books
                books?.forEach { Timber.i("%s", it.toString()) }

                // display book as a list
            }

            override fun onFailure(call: Call<List<Book>>, t: Throwable) {

            }
        })
    }

}
