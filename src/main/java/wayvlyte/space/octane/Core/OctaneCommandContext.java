package wayvlyte.space.octane.Core;

import discord4j.core.event.domain.message.MessageCreateEvent;
import wayvlyte.space.octane.OctaneConfig;

public class OctaneCommandContext {
    private final String[] Arguments;

    public OctaneCommandContext(MessageCreateEvent EventContext) {
        Arguments = EventContext.getMessage()
                .getContent()
                .substring(OctaneConfig.Get("commands.prefix").length())
                .split("/ +/");
    }

    public String GetCommandFriendly() {
        return Arguments[0].toLowerCase();
    }

    public boolean IsArgumentsEmpty() {
        return Arguments.length == 0;
    }

    public String[] GetArguments() {
        return Arguments;
    }
}
