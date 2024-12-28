package bet.astral.stream.style;

import bet.astral.text.api.component.Component;

/**
 * Metadata for player/group style data
 * @author Antritus
 * @since 1.0.0
 */
public interface Metadata {
    /**
     * Returns the prefix
     * @return prefix
     */
    Component getPrefix();

    /**
     * Sets the prefix
     * @param prefix metadata
     */
    void setPrefix(Component prefix);

    /**
     * Returns true if the prefix is set
     * @return has prefix
     */
    boolean hasPrefix();

    /**
     * Returns the suffix
     * @return suffix
     */
    Component getSuffix();

    /**
     * Sets the suffix
     * @param suffix suffix
     */
    void setSuffix(Component suffix);

    /**
     * Returns true if the suffix is set
     * @return has suffix
     */
    boolean hasSuffix();

    /**
     * Returns the nickname
     * @return nickname
     */
    Component getNickname();

    /**
     * Sets the nickname
     * @param nickname nickname
     */
    void setNickname(Component nickname);

    /**
     * Returns true if the nickname is set
     * @return nickname
     */
    boolean hasNickname();

    /**
     * Returns the weight of this metadata
     * @return weight
     */
    int getWeight();

    /**
     * Sets the weight
     * @param weight weight
     */
    void setWeight(int weight);
}
