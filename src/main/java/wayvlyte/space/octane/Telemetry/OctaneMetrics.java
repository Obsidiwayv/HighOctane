package wayvlyte.space.octane.Telemetry;

public class OctaneMetrics {
    /* Events that were ran this session, excluding internal events */
    public static MetricsTag EVENTS_TAG = new MetricsTag("Events");

    /* The amount of commands that user that ran */
    public static MetricsTag COMMANDS_TAG = new MetricsTag("Commands");
}
