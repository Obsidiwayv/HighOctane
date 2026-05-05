package wayvlyte.space.octane;

import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.Event;
import wayvlyte.space.octane.Entities.IEventResponder;
import wayvlyte.space.octane.Telemetry.OctaneMetrics;

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
                IEventResponder<?> DispatcherInstance = (IEventResponder<?>) EventDispatcherClass.getDeclaredConstructor().newInstance();
                _RegisterDiscordEvent(Gateway, DispatcherInstance);
            } catch (Exception _) {
                System.out.printf("%s Was unable to be loaded as a discord event, it will not be executed", EventName);
            }
        }
    }

    /**
     * Private method to execute discord events with generic provided
     */
    private static <T extends Event>void _RegisterDiscordEvent(GatewayDiscordClient Gateway, IEventResponder<T> EventDispatcher) {
        Gateway.getEventDispatcher()
                .on(EventDispatcher.GetEventClass())
                .flatMap(EventDispatcher::Execute)
                .doOnNext(_ -> OctaneMetrics.EVENTS_TAG.Inc() /* Increase the event count */)
                .subscribe();
    }
}
