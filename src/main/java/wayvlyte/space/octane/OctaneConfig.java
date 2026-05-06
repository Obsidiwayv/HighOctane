package wayvlyte.space.octane;

import com.electronwill.nightconfig.core.file.FileConfig;

public class OctaneConfig {
    private static final FileConfig Conf = FileConfig.of("client.config.toml");

    public static void Load() {
        Conf.load();
    }

    public static <T>T Get(String Key) {
        return Conf.get(Key);
    }
}
