package wayvlyte.space.octane.Core;

import wayvlyte.space.octane.Enums.EVersion;

import java.util.List;

public class OctaneVersions {
    public record VersionEntry(EVersion Release, int Major, int Minor, boolean bSnapshot) {}

    public static VersionEntry DEVELOPMENT_1_0 = new VersionEntry(EVersion.DEVELOPMENT, 1, 0, true);

    public static VersionEntry THORIUM_1_0 = new VersionEntry(EVersion.THORIUM, 1, 0, false);

    public static final List<VersionEntry> ALL = List.of(
            DEVELOPMENT_1_0,
            THORIUM_1_0
    );
}
