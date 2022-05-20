package com.safaorhan.events.test

import com.safaorhan.events.Event
import com.safaorhan.events.Events

class TestEvents : Events {
    val events = mutableListOf<Event>()

    override suspend fun send(event: Event) {
        events.add(event)
    }
}