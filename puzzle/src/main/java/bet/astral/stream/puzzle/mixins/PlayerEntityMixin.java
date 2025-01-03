package bet.astral.stream.puzzle.mixins;

import bet.astral.stream.utils.Player;
import bet.astral.text.api.component.Component;
import finalforeach.cosmicreach.entities.player.PlayerEntity;
import finalforeach.cosmicreach.lang.Lang;
import finalforeach.cosmicreach.networking.packets.MessagePacket;
import finalforeach.cosmicreach.networking.server.ServerSingletons;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

/**
 * @since 1.0.6
 * @author Antritus
 */
@Mixin(PlayerEntity.class)
public class PlayerEntityMixin implements Player {
    @Shadow public transient finalforeach.cosmicreach.entities.player.Player player;

    @Override
    public String getId() {
        return player.getAccount().getUniqueId();
    }

    @Override
    public void sendMessage(Component... message) {
        StringBuilder messageBuilder = new StringBuilder();
        for (Component component : message){
            if (component == null){
                messageBuilder.append("null");
            }
            if (component.isLanguage()){
                messageBuilder.append(Lang.get(component.getValue()));
            } else {
                messageBuilder.append(component.getValue());
            }
        }
        MessagePacket packet = new MessagePacket(messageBuilder.toString());
        packet.setupAndSend(ServerSingletons.getConnection(player));
    }
}
