package bet.astral.stream.provider;

import bet.astral.stream.utils.Identifier;
import bet.astral.text.api.component.Component;

/**
 * Required implementation for each stream mod/plugin
 * @author Antritus
 * @since 1.0.0
 */
public abstract class StreamProvider {
    protected static StreamProvider provider;

    /**
     * Creates a new identifier instance
     * @param namespace namespace
     * @param value value
     * @return new identifier
     */
    public static Identifier createIdentifier(String namespace, String value) {
        return provider.identifier(namespace, value);
    }

    /**
     * Creates a new identifier instance
     * @param namespace namespace
     * @param value value
     * @return identifier
     */
    public abstract Identifier identifier(String namespace, String value);

    /**
     * Creates a new component based on the text given
     * @param text text
     * @return component
     */
    public static Component createText(String text){
        return provider.componentText(text);
    }

    /**
     * Creates a new text component
     * @param text text
     * @return component
     */
    public abstract Component componentText(String text);

    /**
     * Creates a new language component which has a translation when parsed by the client
     * @param key translation key
     * @return component
     */
    public static Component createLang(String key){
        return provider.componentText(key);
    }

    /**
     * Creates a new language component which has a translation key as the value
     * @param key key
     * @return component
     */
    public Component componentLang(String key) {
        return componentText(key);
    }
}
