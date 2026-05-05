package wayvlyte.space.octane.Telemetry;

public class MetricsTag {
    private int Index = 0;
    private final String TagName;

    public MetricsTag(String TagName) {
        this.TagName = TagName;
    }

    public void Inc() {
        Index++;
    }

    public void Dec() {
        Index--;
    }

    public String getTagName() {
        return TagName;
    }

    public int getIndex() {
        return Index;
    }
}
