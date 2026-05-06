package wayvlyte.space.octane.Telemetry;

public class OctaneMetricsCounter {
    private int Index = 0;
    private final String TagName;

    public OctaneMetricsCounter(String TagName) {
        this.TagName = TagName;
    }

    public void Inc() {
        Index++;
    }

    public void Dec() {
        Index--;
    }

    public String GetName() {
        return TagName;
    }

    public int GetIndex() {
        return Index;
    }
}
