package fr.android.androidexercises

interface ItemView<in T> {
    fun bind(element: T)
}