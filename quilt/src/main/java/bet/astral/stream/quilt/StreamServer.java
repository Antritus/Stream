package bet.astral.stream.quilt;

import bet.astral.stream.provider.StreamProvider;
import bet.astral.stream.utils.Identifier;
import bet.astral.text.api.component.Component;
import dev.crmodders.cosmicquilt.api.entrypoint.ModInitializer;
import org.quiltmc.loader.api.ModContainer;

public class StreamServer extends StreamProvider implements ModInitializer{
    public static boolean acceptsNew = true;
    @Override
    public void onInitialize(ModContainer modContainer) {
        acceptsNew = false;
    }

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
        return ;
    }
}