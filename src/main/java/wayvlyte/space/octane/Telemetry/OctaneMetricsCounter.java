package wayvlyte.space.octane.Telemetry;

import java.util.concurrent.atomic.AtomicInteger;

public class OctaneMetricsCounter {
    private final AtomicInteger Index = new AtomicInteger(0);
    private final String TagName;

    public OctaneMetricsCounter(String TagName) {
        this.TagName = TagName;
    }

    public void Inc() {
        Index.incrementAndGet();
    }

    public void Dec() {
        Index.decrementAndGet();
    }

    public String GetName() {
        return TagName;
    }

    public AtomicInteger GetIndex() {
        return Index;
    }
}
