package fr.clementgarbay.android.generic.ui

import android.view.View

/**
 * @author Clément Garbay <contact@clementgarbay.fr>
 */
interface BindableView<in T> {
    fun bind(item: T): View
}