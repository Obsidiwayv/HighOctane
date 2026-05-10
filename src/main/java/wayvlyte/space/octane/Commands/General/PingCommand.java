package wayvlyte.space.octane.Commands.General;

import discord4j.core.event.domain.message.MessageCreateEvent;
import reactor.core.publisher.Mono;
import wayvlyte.space.octane.Annotations.CLOctaneCommand;
import wayvlyte.space.octane.Core.OctaneCommandContext;
import wayvlyte.space.octane.Entities.ICommand;
import wayvlyte.space.octane.Enums.ECommandCategory;
import wayvlyte.space.octane.Enums.ECommandLevel;

@CLOctaneCommand(
        Name = "ping",
        Description = "Show the total amount of milliseconds it takes for octane to reach discords servers",
        Category = ECommandCategory.General,
        ExecutionLevel = ECommandLevel.Admin
)
public class PingCommand implements ICommand {
    @Override
    public Mono<?> Execute(MessageCreateEvent EventContext, OctaneCommandContext Command) {
        EventContext.getMessage().getChannel().block().createMessage("E").block();
        return Mono.empty();
    }
}
