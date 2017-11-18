package fr.clementgarbay.android.adapters

import android.view.View

/**
 * @author Clément Garbay <contact@clementgarbay.fr>
 */
interface ItemView<in T> {
    fun bindView(item: T): View
}