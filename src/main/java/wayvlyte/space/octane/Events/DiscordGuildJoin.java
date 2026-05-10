package wayvlyte.space.octane.Events;

import discord4j.core.event.domain.guild.GuildCreateEvent;
import reactor.core.publisher.Mono;
import wayvlyte.space.octane.Entities.IEventResponder;
import wayvlyte.space.octane.Telemetry.OctaneMetrics;

public class DiscordGuildJoin implements IEventResponder<GuildCreateEvent> {

    @Override
    public Class<GuildCreateEvent> GetEventClass() {
        return GuildCreateEvent.class;
    }

    @Override
    public Mono<?> Execute(GuildCreateEvent EventContext) {
        /* Counting up on the guilds meter */
        OctaneMetrics.GUILDS.Inc();

        System.out.println("Joined guild");

        return Mono.empty();
    }
}
