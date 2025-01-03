package bet.astral.stream.quilt.mixins;

import bet.astral.stream.utils.Player;
import bet.astral.text.api.component.Component;
import finalforeach.cosmicreach.entities.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

/**
 * @since 1.0.6
 * @author Antritus
 */
@Mixin(finalforeach.cosmicreach.entities.player.Player.class)
public abstract class PlayerMixin implements Player {
    @Shadow private Entity entity;

    @Override
    public void sendMessage(Component component) {
        ((Player) entity).sendMessage(component);
    }

    @Override
    public String getId() {
        return ((Player) entity).getId();
    }
}