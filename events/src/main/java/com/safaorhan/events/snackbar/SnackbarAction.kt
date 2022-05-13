package com.safaorhan.events.snackbar

import androidx.annotation.StringRes

data class SnackbarAction(
    @StringRes val label: Int,
    val action: () -> Unit
)