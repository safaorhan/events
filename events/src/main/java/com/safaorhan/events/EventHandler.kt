package com.safaorhan.events

import android.view.View

interface EventHandler<T : Event> {
    fun handle(view: View, event: T)
}