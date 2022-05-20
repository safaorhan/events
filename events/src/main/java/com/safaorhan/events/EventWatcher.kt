package com.safaorhan.events

/**
 * EventWatchers are supposed to do non-blocking operations without affecting the emitted event.
 *
 * Any event that is sent passes through all EventWatchers added to the `Events` instance, before
 * being delegated and handled.
 *
 * @see EventsImpl#addEventWatcher
 */
interface EventWatcher {
    fun watch(event: Event)
}