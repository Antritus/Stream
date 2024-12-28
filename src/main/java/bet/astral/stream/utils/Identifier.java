package bet.astral.stream.utils;

import bet.astral.stream.provider.StreamProvider;

/**
 * Identifier for plugins/mods which need it
 * @author Antritus
 * @since 1.0.0
 */
public interface Identifier {
    /**
     * Returns the namespace of this identifier (namespace:value)
     * @return namespace
     */
    String getNamespace();

    /**
     * Returns the value (key) of this identifier (namespace:value)
     * @return value
     */
    String getValue();

    /**
     * Creates a new identifier instance (namespace:value)
     * @param namespace namespace
     * @param value value
     * @return new identifier
     */
    static Identifier of(String namespace, String value) {
        return StreamProvider.createIdentifier(namespace, value);
    }
}
