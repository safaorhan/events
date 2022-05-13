package com.safaorhan.events.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.safaorhan.events.Events
import com.safaorhan.events.collectEventsFrom
import com.safaorhan.events.navigation.NavigationEventHandler
import com.safaorhan.events.snackbar.SnackbarEventHandler
import com.safaorhan.events.toast.ToastEvent
import com.safaorhan.events.toast.ToastEventHandler
import com.safaorhan.text.asText
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}