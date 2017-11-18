package fr.clementgarbay.android.generic.ui.handler

/**
 * @author Clément Garbay <contact@clementgarbay.fr>
 */
interface ItemClickedListener<in T> {
    fun onItemClicked(item: T)
}