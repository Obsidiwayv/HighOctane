package wayvlyte.space.octane.Events;

import discord4j.core.event.domain.lifecycle.ReadyEvent;
import reactor.core.publisher.Mono;
import wayvlyte.space.octane.Entities.IEventResponder;

public class DiscordReady implements IEventResponder<ReadyEvent> {
    @Override
    public Class<ReadyEvent> GetEventClass() {
        return ReadyEvent.class;
    }

    @Override
    public Mono<?> Execute(ReadyEvent EventContext) {
        System.out.printf("%s is ready on %d guilds%n",
                EventContext.getSelf().getUsername(), EventContext.getGuilds().size());
        return Mono.empty();
    }
}
