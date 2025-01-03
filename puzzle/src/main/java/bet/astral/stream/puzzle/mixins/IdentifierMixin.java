package bet.astral.stream.puzzle.mixins;

import finalforeach.cosmicreach.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

/**
 * @since 1.0.0
 * @author Antritus
 */
@Mixin(Identifier.class)
public class IdentifierMixin implements bet.astral.stream.utils.Identifier {
    @Shadow protected String namespace;
    @Shadow protected String name;

    @Override
    public String getNamespace() {
        return namespace;
    }

    @Override
    public String getValue() {
        return name;
    }
}