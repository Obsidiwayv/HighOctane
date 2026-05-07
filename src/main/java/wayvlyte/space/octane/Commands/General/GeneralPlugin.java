package wayvlyte.space.octane.Commands.General;

import wayvlyte.space.octane.Entities.ICommand;
import wayvlyte.space.octane.Bases.OctanePluginBase;

public class GeneralPlugin extends OctanePluginBase {
    public GeneralPlugin() {
        LoadCommands(new ICommand[]{
                new PingCommand()
        });
    }
}
