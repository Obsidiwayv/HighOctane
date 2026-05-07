package wayvlyte.space.octane.Entities;

import discord4j.core.event.domain.message.MessageCreateEvent;
import reactor.core.publisher.Mono;

public interface ICommand {
    Mono<?> Execute(MessageCreateEvent EventContext);
}
