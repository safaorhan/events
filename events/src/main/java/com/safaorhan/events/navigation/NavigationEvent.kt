package com.safaorhan.events.navigation

import androidx.navigation.NavDirections
import com.safaorhan.events.Event

data class NavigationEvent(
    val navDirections: NavDirections
) : Event
