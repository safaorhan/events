package com.safaorhan.events.snackbar

import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.safaorhan.events.EventHandler
import com.safaorhan.text.resolveToString

object SnackbarEventHandler : EventHandler<SnackbarEvent> {
    override fun handle(view: View, event: SnackbarEvent) {
        Snackbar.make(view, event.message.resolveToString(view.resources), event.duration).apply {
            when (event.action) {
                null -> setAction(null, null)
                else -> setAction(event.action.label) {
                    event.action.action()
                }
            }
        }.show()
    }
}