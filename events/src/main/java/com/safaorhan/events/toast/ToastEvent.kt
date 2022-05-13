package com.safaorhan.events.toast

import android.widget.Toast
import com.safaorhan.events.Event
import com.safaorhan.text.Text

data class ToastEvent(
    val message: Text,
    val duration: Int = Toast.LENGTH_LONG
) : Event