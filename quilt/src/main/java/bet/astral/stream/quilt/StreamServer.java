package bet.astral.stream.quilt;

import bet.astral.stream.provider.StreamProvider;
import bet.astral.stream.utils.Identifier;
import bet.astral.text.api.component.BasicComponent;
import bet.astral.text.api.component.Component;
import dev.crmodders.cosmicquilt.api.entrypoint.server.ServerModInitializer;
import org.quiltmc.loader.api.ModContainer;

public class StreamServer extends StreamProvider implements ServerModInitializer {
    public static boolean acceptsNew = true;
    @Override
    public boolean acceptsNewRegistries() {
        return acceptsNew;
    }

    @Override
    public Identifier identifier(String s, String s1) {
        return (Identifier) finalforeach.cosmicreach.util.Identifier.of(s, s1);
    }
    @Override
    public Component componentText(String s) {
        return new BasicComponent(s, true);
    }

    @Override
    public Component componentLang(String key) {
        return new BasicComponent(key, false);
    }

    @Override
    public void onInitializeServer(ModContainer modContainer) {

    }
}