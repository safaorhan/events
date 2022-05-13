package com.safaorhan.events.navigation

import android.view.View
import androidx.navigation.findNavController
import com.safaorhan.events.EventHandler


object NavigationEventHandler : EventHandler<NavigationEvent> {
    override fun handle(view: View, event: NavigationEvent) {
        val navController = view.findNavController()

        when (event.navDirections) {
            Back -> navController.popBackStack()
            else -> navController.navigate(event.navDirections)
        }
    }
}