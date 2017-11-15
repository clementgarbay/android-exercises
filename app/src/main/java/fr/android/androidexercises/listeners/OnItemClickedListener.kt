package fr.android.androidexercises.listeners

/**
 * @author Clément Garbay <contact@clementgarbay.fr>
 */
interface OnItemClickedListener<in T> {
    fun onItemClicked(item: T)
}