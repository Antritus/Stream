package bet.astral.stream.puzzle;

import bet.astral.stream.provider.StreamProvider;
import bet.astral.stream.utils.Identifier;
import bet.astral.text.api.component.BasicComponent;
import bet.astral.text.api.component.Component;
import com.github.puzzle.core.loader.provider.mod.entrypoint.impls.ModInitializer;

/**
 * @author Antritus
 * @since 1.0.0
 */
public class Stream extends StreamProvider implements ModInitializer {
    public static boolean accepts = true;
    @Override
    public void onInit() {
        provider = this;
    }

    @Override
    public boolean acceptsNewRegistries() {
        return accepts;
    }

    @Override
    public Identifier identifier(String namespace, String value) {
        return (Identifier) finalforeach.cosmicreach.util.Identifier.of(namespace, value);
    }
    @Override
    public Component componentText(String s) {
        return new BasicComponent(s, true);
    }

    @Override
    public Component componentLang(String key) {
        return new BasicComponent(key, false);
    }

}
