package wayvlyte.space.octane.Annotations;

import wayvlyte.space.octane.Core.OctaneVersions;
import wayvlyte.space.octane.Entities.ICommand;
import wayvlyte.space.octane.Enums.ECommandCategory;
import wayvlyte.space.octane.Enums.ECommandLevel;
import wayvlyte.space.octane.Enums.EVersion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface CLOctaneCommand {
    String Name();
    String Description();
    ECommandCategory Category();
    ECommandLevel ExecutionLevel() default ECommandLevel.None;
    EVersion AddIn() default EVersion.DEVELOPMENT;
    long Cooldown() default 10_000;
    Class<? extends ICommand>[] SubCommands() default {};
}
