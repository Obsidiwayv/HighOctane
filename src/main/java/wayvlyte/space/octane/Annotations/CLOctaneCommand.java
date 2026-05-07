package wayvlyte.space.octane.Annotations;

import wayvlyte.space.octane.Entities.ICommand;
import wayvlyte.space.octane.Enums.ECommandLevel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface CLOctaneCommand {
    String Name();
    String Description();
    ECommandLevel ExecutionLevel() default ECommandLevel.None;
    long Cooldown() default 10_000;
    Class<? extends ICommand>[] SubCommands() default {};
}
