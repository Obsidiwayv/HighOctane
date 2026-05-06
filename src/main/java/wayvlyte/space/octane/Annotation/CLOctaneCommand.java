package wayvlyte.space.octane.Annotation;

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
    ECommandLevel Level();
}
