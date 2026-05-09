package wayvlyte.space.octane;

import com.electronwill.nightconfig.core.file.FileConfig;

import java.io.File;

public class OctaneConfig {
    private static final String ConfigFileName = "client.config.toml";
    private static final FileConfig Conf = FileConfig.of(ConfigFileName);
    /**
     * Property that determines if this class will use either use Environment Values or A TOML file
     */
    private static boolean bHasConfig = true;

    public static void Load() {
        File ConfigFile = new File(ConfigFileName);
        // Check if the file exists if not then fallback to the servers environment
        if (!ConfigFile.exists()) {
            System.out.println("Unable to load config file, environment values will be used when using Get(key)");
            bHasConfig = false;
            return;
        }
        Conf.load();
    }

    public static String Get(String Key) {
        if (!bHasConfig || !Conf.contains(Key)) {
            String EnvName = Key.replace(".", "_").toUpperCase();
            return System.getenv(EnvName);
        }
        return Conf.get(Key);
    }
}
