package com.safaorhan.events

class TestEvents : Events {
    val events = mutableListOf<Event>()

    override suspend fun send(event: Event) {
        events.add(event)
    }
}