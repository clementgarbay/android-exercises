package fr.clementgarbay.android.book.infrastructure.persistence.api

import fr.clementgarbay.android.book.domain.model.Book
import retrofit2.Call
import retrofit2.http.GET

/**
 * @author Clément Garbay <contact@clementgarbay.fr>
 */
interface HenriPotierService {

    @GET("books")
    fun listBooks(): Call<List<Book>>

}


