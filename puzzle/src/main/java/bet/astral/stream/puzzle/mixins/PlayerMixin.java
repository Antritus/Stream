package bet.astral.stream.puzzle.mixins;

import finalforeach.cosmicreach.accounts.Account;
import finalforeach.cosmicreach.entities.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

/**
 * Mixins the player interface to the server player
 * @author Antritus
 * @since 1.0.0
 */
@Mixin(Player.class)
public abstract class PlayerMixin implements bet.astral.stream.utils.Player {
    @Shadow public abstract Account getAccount();

    @Override
    public String getId() {
        return getAccount().getUniqueId();
    }
}
