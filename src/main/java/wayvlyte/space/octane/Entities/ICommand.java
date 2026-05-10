package wayvlyte.space.octane.Entities;

import discord4j.core.event.domain.message.MessageCreateEvent;
import reactor.core.publisher.Mono;
import wayvlyte.space.octane.Core.OctaneCommandContext;

public interface ICommand {
    Mono<?> Execute(MessageCreateEvent EventContext, OctaneCommandContext Command);
}
