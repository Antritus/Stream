package bet.astral.stream.style;

/**
 * Style provider to handle the styles of the server
 * @author Antritus
 * @since 1.0.0
 */
public interface StyleProvider {
    /**
     * Returns the global style of the server
     * @return style
     */
    Style getStyle();

    /**
     * Returns the style of the given world
     * @param world world
     * @return style
     */
    Style getStyleFromWorld(String world);

    /**
     * Unhooks the style provider from the stream api
     */
    void unhookStyle();
}
