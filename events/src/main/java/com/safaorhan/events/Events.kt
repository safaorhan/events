package com.safaorhan.events

import android.view.View
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlin.reflect.KClass

class Events private constructor(
    private val handlers: Map<KClass<out Event>, EventHandler<out Event>>,
    private val watchers: List<EventWatcher>
) {

    private val channel = Channel<Event>(Channel.BUFFERED)
    private val flow = channel.receiveAsFlow()

    private fun watch(event: Event) = watchers.forEach { watcher ->
        watcher.watch(event)
    }

    @Suppress("UNCHECKED_CAST")
    private fun delegate(event: Event, view: View) {
        println(event)
        val handler = handlers[event::class] ?: throw IllegalStateException(
            "Event $event is not handled by any EventHandler. Have you registered this event?"
        )

        (handler as EventHandler<Event>).handle(view, event)
    }

    suspend fun send(event: Event) = channel.send(event)

    internal suspend fun collectEvents(view: View) = flow.collect {
        println("Processing event: $it")
        watch(it)
        delegate(it, view)
    }

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

        fun build() = Events(handlers.toMap(), watchers.toList())
    }
}