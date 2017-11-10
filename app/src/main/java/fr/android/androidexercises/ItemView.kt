package fr.android.androidexercises

interface ItemView<T> {
    fun bind(element: T)
}