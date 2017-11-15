package fr.android.androidexercises.services

import fr.android.androidexercises.models.Book
import retrofit2.Call
import retrofit2.http.GET

/**
 * @author Clément Garbay <contact@clementgarbay.fr>
 */
interface HenriPotierService {

    @GET("books")
    fun listBooks(): Call<List<Book>>

}


