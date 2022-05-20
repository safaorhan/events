package com.safaorhan.events

import kotlin.reflect.KClass

interface Events {
    suspend fun send(event: Event)

    class Builder {
        val handlers = mutableMapOf<KClass<out Event>, EventHandler<out Event>>()
        val watchers = mutableListOf<EventWatcher>()

        inline fun <reified T : Event> registerHandler(handler: EventHandler<T>): Builder {
            handlers[T::class] = handler
            return this
        }

        fun registerWatcher(watcher: EventWatcher): Builder {
            watchers.add(watcher)
            return this
        }

        fun registerWatcher(watcher: (event: Event) -> Unit): Builder {
            registerWatcher(object : EventWatcher {
                override fun watch(event: Event) {
                    watcher(event)
                }
            })
            return this
        }

        fun build() = EventsImpl(handlers.toMap(), watchers.toList())
    }
}