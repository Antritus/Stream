package bet.astral.stream.quilt.mixins;

import finalforeach.cosmicreach.accounts.Account;
import finalforeach.cosmicreach.entities.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Player.class)
public abstract class PlayerMixin implements bet.astral.stream.utils.Player {
    @Shadow public abstract Account getAccount();

    @Override
    public String getId() {
        return getAccount().getUniqueId();
    }
}