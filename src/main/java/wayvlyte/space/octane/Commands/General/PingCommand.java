package wayvlyte.space.octane.Commands.General;

import discord4j.core.event.domain.message.MessageCreateEvent;
import reactor.core.publisher.Mono;
import wayvlyte.space.octane.Annotations.CLOctaneCommand;
import wayvlyte.space.octane.Entities.ICommand;

@CLOctaneCommand(
        Name = "ping",
        Description = "Show the total amount of milliseconds it takes for octane to reach discords servers"
)
public class PingCommand implements ICommand {
    @Override
    public Mono<?> Execute(MessageCreateEvent EventContext) {
        return Mono.empty();
    }
}
