package wayvlyte.space.octane.Core;

import discord4j.common.util.Snowflake;
import wayvlyte.space.octane.Telemetry.OctanePublicMetrics;

public class OctaneGuild {
    private final Snowflake ID;
    private final OctanePublicMetrics Metrics = new OctanePublicMetrics();

    public OctaneGuild(Snowflake ID) {
        this.ID = ID;
    }

    public OctanePublicMetrics GetMetrics() {
        return Metrics;
    }

    public Snowflake GetID() {
        return ID;
    }
}
