package com.safaorhan.events.navigation

import androidx.core.os.bundleOf
import androidx.navigation.NavDirections
import com.safaorhan.events.R

object Back : NavDirections {
    override val actionId = R.id.events_navigation_back
    override val arguments = bundleOf()
}
