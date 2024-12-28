package bet.astral.stream.style;

import bet.astral.stream.utils.Group;
import bet.astral.stream.utils.Player;
import bet.astral.text.api.component.Component;

/**
 * Wrapper for style to allow easier player access. This is split into two classes to simplify the style class
 * @author Antritus
 * @since 1.0.0
 */
public interface StyleWrapperPlayer{
    Style wrapper();
    /**
     * Returns the prefix of the given player
     * @param player player
     * @return prefix
     */
    default Component getPrefix(Player player) {
        return wrapper().getPrefix(player.getId());
    }

    /**
     * Sets the prefix of the given player
     * @param player player
     * @param prefix prefix
     */
    default void setPrefix(Player player, Component prefix) {
        wrapper().setPrefix(player.getId(), prefix);
    }

    /**
     * Returns true if the player has a prefix
     * @param player player
     * @return true, if the player has a prefix
     */
    default boolean hasPrefix(Player player) {
        return wrapper().hasPrefix(player.getId());
    }

    /**
     * Returns the suffix of the player
     *
     * @param player player
     * @return suffix
     */
    default Component getSuffix(Player player) {
        return wrapper().getSuffix(player.getId());
    }

    /**
     * Sets the suffix of the player
     * @param player player
     * @param suffix suffix
     */
    default void setSuffix(Player player, Component suffix) {
        wrapper().setSuffix(player.getId(), suffix);
    }

    /**
     * Returns true if the player has a suffix
     * @param player player
     * @return true, if the player has a style
     */
    default boolean hasSuffix(Player player) {
        return wrapper().hasSuffix(player.getId());
    }

    /**
     * Returns the nickname of the given player
     * @param player player
     * @return nickname
     */
    default Component getNickname(Player player) {
        return wrapper().getNickname(player.getId());
    }

    /**
     * Sets the nickname of the given player
     * @param player player
     * @param nickname nickname
     */
    default void setNickname(Player player, Component nickname) {
        wrapper().setNickname(player.getId(), nickname);
    }

    /**
     * Returns true if the player has a nickname
     * @param player player 
     * @return nickname
     */
    default boolean hasNickname(Player player) {
        return wrapper().hasNickname(player.getId());
    }

    /**
     * Returns the player's weight in the server (higher = better)
     * @param player player
     * @return weight
     */
    default int getWeight(Player player) {
        return wrapper().getWeight(player.getId());
    }

    /**
     * Sets the player's weight in the server
     * @param player player
     * @param weight weight
     */
    default void setWeight(Player player, int weight) {
        wrapper().setWeight(player.getId(), weight);
    }

    /**
     * Returns the groups of a given player
     * @param player player 
     * @return groups
     */
    default Group[] getGroups(Player player) {
        return wrapper().getGroups(player.getId());
    }
}
