package fr.android.androidexercises.models

import android.os.Parcel
import android.os.Parcelable

/**
 * @author Clément Garbay <contact@clementgarbay.fr>
 */
data class Book(val isbn: String? = null,
                val title: String? = null,
                val price: String? = null,
                val cover: String? = null
) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString())

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(isbn)
        dest.writeString(title)
        dest.writeString(price)
        dest.writeString(cover)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Book> {
        override fun createFromParcel(parcel: Parcel): Book = Book(parcel)
        override fun newArray(size: Int): Array<Book?> = arrayOfNulls(size)
    }
}
