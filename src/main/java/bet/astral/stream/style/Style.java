package bet.astral.stream.style;

import bet.astral.stream.utils.Group;
import bet.astral.text.api.component.Component;

/**
 * Style manager
 * @author Antritus
 * @since 1.0.0
 */
public abstract class Style implements StyleWrapperPlayer {
    @Override
    public final Style wrapper() {
        return this;
    }

    /**
     * Returns the prefix of the given player
     * @param playerId player
     * @return prefix
     */
    public abstract Component getPrefix(String playerId);

    /**
     * Sets the prefix of the given player
     * @param playerId player
     * @param prefix prefix
     */
    public abstract void setPrefix(String playerId, Component prefix);

    /**
     * Returns true if the player has a prefix
     * @param playerId player
     * @return true, if the player has a prefix
     */
    public abstract boolean hasPrefix(String playerId);

    /**
     * Returns the suffix of the player
     * @param playerId player
     * @return suffix
     */
    public abstract Component getSuffix(String playerId);

    /**
     * Sets the suffix of the player
     * @param playerId player
     * @param suffix suffix
     */
    public abstract void setSuffix(String playerId, Component suffix);

    /**
     * Returns true if the player has a suffix
     * @param playerId player
     * @return true, if the player has a style
     */
    public abstract boolean hasSuffix(String playerId);

    /**
     * Returns the nickname of the given player
     * @param playerId player
     * @return nickname
     */
    public abstract Component getNickname(String playerId);

    /**
     * Sets the nickname of the the given player
     * @param playerId player
     * @param nickname nickname
     */
    public abstract void setNickname(String playerId, Component nickname);

    /**
     * Returns true if the player has a nickname
     * @param playerId player
     * @return nickname
     */
    public abstract boolean hasNickname(String playerId);

    /**
     * Returns the player's weight in the server (higher = better)
     * @param playerId player
     * @return weight
     */
    public abstract int getWeight(String playerId);

    /**
     * Sets the player's weight in the server
     * @param playerId player
     * @param weight weight
     */
    public abstract void setWeight(String playerId, int weight);

    /**
     * Returns true if groups are supported by the style manager
     * @return true if supported
     */
    public abstract boolean areGroupsSupported();
    /**
     * Returns the groups of a given player
     * @param playerId player
     * @return groups
     */
    public abstract Group[] getGroups(String playerId);
}
