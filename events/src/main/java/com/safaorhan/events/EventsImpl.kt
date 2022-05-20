package com.safaorhan.events

import android.view.View
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlin.reflect.KClass

class EventsImpl internal constructor(
    private val handlers: Map<KClass<out Event>, EventHandler<out Event>>,
    private val watchers: List<EventWatcher>
): Events {

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

    override suspend fun send(event: Event) = channel.send(event)

    internal suspend fun collectEvents(view: View) = flow.collect {
        println("Processing event: $it")
        watch(it)
        delegate(it, view)
    }
}