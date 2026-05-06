package wayvlyte.space.octane.Events;

import discord4j.core.event.domain.guild.GuildDeleteEvent;
import reactor.core.publisher.Mono;
import wayvlyte.space.octane.Entities.IEventResponder;
import wayvlyte.space.octane.Telemetry.OctaneMetrics;

public class DiscordGuildLeave implements IEventResponder<GuildDeleteEvent> {

    @Override
    public Class<GuildDeleteEvent> GetEventClass() {
        return GuildDeleteEvent.class;
    }

    @Override
    public Mono<?> Execute(GuildDeleteEvent EventContext) {
        /* :( */
        OctaneMetrics.GUILDS.Dec();

        return null;
    }
}
