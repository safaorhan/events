package com.safaorhan.events.snackbar

import com.safaorhan.events.Event
import com.safaorhan.text.Text

data class SnackbarEvent(
    val message: Text,
    val duration: Int,
    val action: SnackbarAction? = null
) : Event