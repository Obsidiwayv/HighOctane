package wayvlyte.space.octane;

import wayvlyte.space.octane.Bases.OctanePluginBase;
import wayvlyte.space.octane.Commands.General.GeneralPlugin;
import wayvlyte.space.octane.Commands.GeometryDash.GeometryDashPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OctaneCommandRegistry {
    private static final HashMap<String, OctanePluginBase.CommandMeta> PluginCommands = new HashMap<>();
    private static final List<OctanePluginBase> Plugins = List.of(
            new GeneralPlugin(),
            new GeometryDashPlugin()
    );

    public static List<OctanePluginBase> GetPlugins() {
        return Plugins;
    }

    public static HashMap<String, OctanePluginBase.CommandMeta> GetCommands() {
        return PluginCommands;
    }
}
