package wayvlyte.space.octane;

import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.Event;
import wayvlyte.space.octane.Core.OctaneUtil;
import wayvlyte.space.octane.Entities.IEventResponder;
import wayvlyte.space.octane.Enums.EEventType;
import wayvlyte.space.octane.Telemetry.OctaneMetrics;

import java.util.ArrayList;
import java.util.List;

public class OctaneEventRegistry {

    public record EventEntry(String EventName, Boolean Active, EEventType EventType) {}

    private final static List<String> DISCORD_EVENT_NAMES = List.of(
            "DiscordReady",
            "DiscordGuildJoin",
            "DiscordGuildLeave",
            "DiscordMessageCreate"
    );

    // Nothing here yet
    private final static List<String> INTERNAL_EVENT_NAMES = List.of();

    private static final List<EventEntry> REGISTERED_EVENTS = new ArrayList<>();

    public static void RegisterDiscordEvents(GatewayDiscordClient Gateway) {
        for (String EventName : DISCORD_EVENT_NAMES) {
            // Attempt to load the class
            IEventResponder<?> DispatcherInstance = (IEventResponder<?>)
                    OctaneUtil.LoadClass(String.format("wayvlyte.space.octane.Events.%s", EventName));
            boolean bActivated = false;

            // Check if the instance is null, if it's not then proceed
            if (DispatcherInstance != null) {
                _RegisterDiscordEvent(Gateway, DispatcherInstance);
                bActivated = true;
            }
            /* Add the event once it has been successfully registered */
            REGISTERED_EVENTS.add(
                    new EventEntry(EventName, bActivated, EEventType.DiscordEvent));
            System.out.printf("Registered Discord event: %s%n", EventName);
        }
    }

    public static List<EventEntry> GetRegistered() {
        return REGISTERED_EVENTS;
    }

    /**
     * Private method to execute discord events with generic provided
     */
    private static <T extends Event> void _RegisterDiscordEvent(GatewayDiscordClient Gateway, IEventResponder<T> EventDispatcher) {
        Gateway.getEventDispatcher()
                .on(EventDispatcher.GetEventClass())
                .flatMap(EventDispatcher::Execute)
                .doOnNext(_ -> OctaneMetrics.EVENTS.Inc() /* Increase the event count */)
                .subscribe();
    }
}
