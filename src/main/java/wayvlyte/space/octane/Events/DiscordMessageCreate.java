package wayvlyte.space.octane.Events;

import discord4j.common.util.Snowflake;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Member;
import discord4j.core.object.entity.Role;
import discord4j.core.object.entity.User;
import discord4j.rest.util.Permission;
import org.jspecify.annotations.Nullable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import wayvlyte.space.octane.Bases.OctanePluginBase;
import wayvlyte.space.octane.Core.OctaneCommandContext;
import wayvlyte.space.octane.Entities.ICommand;
import wayvlyte.space.octane.Entities.IEventResponder;
import wayvlyte.space.octane.Enums.ECommandLevel;
import wayvlyte.space.octane.OctaneCommandRegistry;
import wayvlyte.space.octane.OctaneConfig;

import java.util.Optional;

public class DiscordMessageCreate implements IEventResponder<MessageCreateEvent> {
    @Override
    public Class<MessageCreateEvent> GetEventClass() {
        return MessageCreateEvent.class;
    }

    @Override
    public Mono<?> Execute(MessageCreateEvent EventContext) {
        OctaneCommandContext Context = new OctaneCommandContext(EventContext);

        if (Context.IsArgumentsEmpty()) return Mono.empty();
        OctanePluginBase.CommandMeta Command = OctaneCommandRegistry.GetCommands()
                .get(Context.GetCommandFriendly());

        if (Command == null) return Mono.empty();
        if (_CanExecute(EventContext) && _HasPermission(EventContext, Command)) {
            Command.PluginCommand().Execute(EventContext, Context);
        }

        return Mono.empty();
    }

    /**
     * Checks if the user can execute this command
     */
    private boolean _CanExecute(MessageCreateEvent EventContext) {
        Optional<User> Author = EventContext.getMessage().getAuthor();
        return Author.filter(user -> !user.isBot()).isPresent();
    }

    private boolean _HasPermission(MessageCreateEvent EventContext, OctanePluginBase.CommandMeta Command) {
        Optional<User> Author = EventContext.getMessage().getAuthor();
        if (Author.isEmpty()) return false;

        // Checking command permission levels
        ECommandLevel Level = _HasCommandLevel(EventContext);
        System.out.printf("Level: %s, Command Level: %s", Level.name(), Command.Metadata().ExecutionLevel().name());
        if (Level.equals(ECommandLevel.None)) return true;
        if (Level.equals(ECommandLevel.Admin) && Command.Metadata().ExecutionLevel() == ECommandLevel.Admin) return true;
        if (Level.equals(ECommandLevel.Owner) && Command.Metadata().ExecutionLevel() == ECommandLevel.Owner) return true;
        //
    }

    private ECommandLevel _HasCommandLevel(MessageCreateEvent Event) {
        Optional<Member> ExecutingMemberOptional = Event.getMember();
        if (ExecutingMemberOptional.isEmpty()) return ECommandLevel.None;

        Member ExecutingMember = ExecutingMemberOptional.get();

        if (ExecutingMember.getId().equals(Snowflake.of(OctaneConfig.Get("client.owner")))) {
            return ECommandLevel.Owner;
        }

        Mono<Role> Roles = ExecutingMember.getRoles()
                .filter(Role -> Role.getPermissions().contains(Permission.ADMINISTRATOR))
                .next();
        return Roles.map(_ -> ECommandLevel.Admin)
                .defaultIfEmpty(ECommandLevel.None)
                .block();
    }
}
