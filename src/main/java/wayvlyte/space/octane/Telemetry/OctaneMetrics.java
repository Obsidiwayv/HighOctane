package wayvlyte.space.octane.Telemetry;

public class OctaneMetrics {
    /* Events that were ran this session, excluding internal events */
    public static OctaneMetricsCounter EVENTS = new OctaneMetricsCounter("Events");

    /* The amount of commands that user that ran */
    public static OctaneMetricsCounter COMMANDS = new OctaneMetricsCounter("Commands");

    public static OctaneMetricsCounter GUILDS = new OctaneMetricsCounter("Servers");
}
