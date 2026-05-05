package wayvlyte.space.octane;

import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.Event;
import wayvlyte.space.octane.Entities.IEventResponder;

import java.lang.reflect.Constructor;
import java.util.List;

public class OctaneEventRegistry {
    private final static List<String> DISCORD_EVENT_NAMES = List.of(
            "DiscordMessageCreate",
            "DiscordReady"
    );

    // Nothing here yet
    private final static List<String> INTERNAL_EVENT_NAMES = List.of();

    public static void RegisterDiscordEvents(GatewayDiscordClient Gateway) {
        for (String EventName : DISCORD_EVENT_NAMES) {
            try {
                Class<?> EventDispatcherClass = Class.forName(String.format("wayvlyte.space.octane.Events.%s", EventName));
            } catch (Exception _) {
                System.out.printf("%s Was unable to be loaded as discord event, it will not be executed", EventName);
            }
        }
    }
}
