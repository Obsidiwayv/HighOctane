package wayvlyte.space.octane.Bases;

import wayvlyte.space.octane.Annotations.CLOctaneCommand;
import wayvlyte.space.octane.Entities.ICommand;
import wayvlyte.space.octane.OctaneCommandRegistry;

public class OctanePluginBase {
    public record CommandMeta(CLOctaneCommand Metadata, ICommand PluginCommand) {}

    public void LoadCommands(ICommand[] CommandList) {
        for (ICommand Command : CommandList) {
            Class<?> CommandClass = Command.getClass();
            if (CommandClass.isAnnotationPresent(CLOctaneCommand.class)) {
                CLOctaneCommand Metadata = CommandClass.getAnnotation(CLOctaneCommand.class);

                OctaneCommandRegistry.GetCommands()
                        .put(Metadata.Name(), new CommandMeta(Metadata, Command));
            }
        }
    }
}
