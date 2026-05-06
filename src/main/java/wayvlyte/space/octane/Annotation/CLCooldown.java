package wayvlyte.space.octane.Annotation;

import wayvlyte.space.octane.OctaneClient;

public @interface CLCooldown {
    long Time() default 10_000;
}
