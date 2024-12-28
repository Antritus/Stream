package bet.astral.stream.annotations;

import java.lang.annotation.*;

/**
 * Shows a method is synced in the execution thread
 * @author Antritus
 * @since 1.0.0
 */
@Documented
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.METHOD)
public @interface Sync {
}
