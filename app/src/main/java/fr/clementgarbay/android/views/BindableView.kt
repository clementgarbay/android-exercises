package fr.clementgarbay.android.views

import android.view.View

/**
 * @author Clément Garbay <contact@clementgarbay.fr>
 */
interface BindableView<in T> {
    fun bind(item: T): View
}