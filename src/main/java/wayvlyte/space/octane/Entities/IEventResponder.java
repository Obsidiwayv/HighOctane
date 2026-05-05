package wayvlyte.space.octane.Entities;

import discord4j.core.event.domain.Event;
import reactor.core.publisher.Mono;

/**
 * An event responder interface to hook into discord gateway events
 * @param <T> A generic extended with a Discord4J event class
 */
public interface IEventResponder<T extends Event> {
    /**
     *
     * @return Event type provided by the method implemented
     */
    public T GetEventClass();
    /**
     * Execute the event the bot has registered
     * @return Mono that could return anything from this event
     */
    public Mono<?> Execute(T EventContext);
}
