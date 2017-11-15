package fr.android.androidexercises.services

import fr.android.androidexercises.models.Book
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber

/**
 * @author Clément Garbay <contact@clementgarbay.fr>
 */
object BooksApi {

    private val ENDPOINT = "http://henri-potier.xebia.fr/"
    private val service: HenriPotierService

    init {
        // Build Retrofit
        val retrofit = Retrofit.Builder()
                .baseUrl(ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        // Create the service
        service = retrofit.create(HenriPotierService::class.java)
    }

    fun getBooks(onResponse: (List<Book>) -> Unit, onFailure: (() -> Unit)?) {
        // Enqueue call and display book title
        service.listBooks().enqueue(object : Callback<List<Book>> {
            override fun onResponse(call: Call<List<Book>>, response: Response<List<Book>>) {
                response.body()?.let {
                    Timber.i("Retrieved %s book(s)", it.size)
                    onResponse(it)
                }
            }

            override fun onFailure(call: Call<List<Book>>, t: Throwable) {
                Timber.e(t, "An error occurred when trying to retrieve books.")
                onFailure?.invoke()
            }
        })
    }

    fun getBooks(onResponse: (List<Book>) -> Unit) {
        getBooks(onResponse, null)
    }
}
