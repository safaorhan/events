package com.safaorhan.events.toast

import android.view.View
import android.widget.Toast
import com.safaorhan.events.EventHandler
import com.safaorhan.text.resolveToString

object ToastEventHandler : EventHandler<ToastEvent> {
    override fun handle(view: View, event: ToastEvent) = with(view) {
        Toast.makeText(context, event.message.resolveToString(resources), event.duration).show()
    }
}