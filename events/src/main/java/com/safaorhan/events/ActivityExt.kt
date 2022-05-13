package com.safaorhan.events


import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle.State.STARTED
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.launch

fun AppCompatActivity.collectEventsFrom(events: Events, view: View) {
    lifecycleScope.launch {
        lifecycle.repeatOnLifecycle(STARTED) {
            events.collectEvents(view)
        }
    }
}