package bet.astral.stream.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Shows a method is synced in an async thread
 * @author Antritus
 * @since 1.0.0
 */
@Documented
@Retention(RetentionPolicy.CLASS)
public @interface ASync {
}
