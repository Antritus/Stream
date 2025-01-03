package bet.astral.stream;

import bet.astral.stream.economy.Currency;
import bet.astral.stream.economy.CurrencyEconomy;
import bet.astral.stream.economy.Economy;
import bet.astral.stream.economy.EconomyProvider;
import bet.astral.stream.permission.Permission;
import bet.astral.stream.permission.PermissionProvider;
import bet.astral.stream.provider.StreamProvider;
import bet.astral.stream.style.Style;
import bet.astral.stream.style.StyleProvider;

/**
 * Stream API (or vault if mc). No, it's not livestreaming or anything similar to it.
 * @author Antritus
 * @since 1.0.0
 */
public class Stream {
    private static StreamProvider provider;
    private static EconomyProvider economy;
    private static StyleProvider style;
    private static PermissionProvider permission;

    /**
     * Internal method. This is not meant for developers.
     * @param provider provider
     * @throws IllegalAccessException if a provider for the api is registered
     */
    public static void provide(StreamProvider provider) throws IllegalAccessException{
        if (Stream.provider != null){
            throw new IllegalAccessException("Cannot change the provider of the Stream API after it is provided!");
        }
        Stream.provider = provider;
    }

    /**
     * Returns the global economy of the server
     * @return global economy
     */
    public static Economy getEconomy() {
        if (economy == null){
            return null;
        }
        return economy.getEconomy();
    }

    /**
     * Returns the economy used for the given world
     * @param worldId world
     * @return economy
     */
    public static Economy getEconomy(String worldId) {
        if (economy == null){
            return null;
        }
        return economy.getEconomy(worldId);
    }

    /**
     * Returns the global economy for given currency in the server
     * @param currency currency to get economy for
     * @return currency
     */
    public static CurrencyEconomy getCurrencyEconomy(Currency currency) {
        if (economy == null){
            return null;
        }
        return economy.getEconomy(currency);
    }

    /**
     * Returns the economy for given currency in the given world
     * @param currency currency
     * @param worldId world
     * @return economy
     */
    public static CurrencyEconomy getCurrencyEconomy(Currency currency, String worldId) {
        if (economy == null){
            return null;
        }
        return economy.getEconomy(currency, worldId);
    }

    /**
     * Returns the global style format for the server
     * @return style
     */
    public static Style getStyle() {
        if (style == null){
            return null;
        }
        return style.getStyle();
    }

    /**
     * Returns the style format for the given world
     * @param world world
     * @return style of the world
     */
    public static Style getStyleOfWorld(String world){
        if (style == null){
            return null;
        }
        return style.getStyleFromWorld(world);
    }

    /**
     * Returns the global permissions manager
     * @return permission manager
     */
    public static Permission getPermission() {
        if (permission == null){
            return null;
        }

        return permission.getPermission();
    }

    /**
     * Returns the permission manager of the given world
     * @param world world
     * @return permission manager
     */
    public static Permission getPermission(String world) {
        if (permission == null){
            return null;
        }

        return permission.getPermissionFromWorld(world);
    }

    /**
     * Registers a new economy provider to the server
     * @param economy economy provider
     * @param override true, if the api should override the previous economy, else false
     * @return result
     */
    public static RegistryResult registerEconomy(EconomyProvider economy, boolean override){
        // Make sure the API is usable and the registry allows new registrations
        if (provider == null){
            return RegistryResult.PROVIDER_NOT_REGISTERED;
        } else if (!provider.acceptsNewRegistries()){
            return RegistryResult.REGISTRY_CLOSED;
        }


        if (Stream.economy != null && !override){
            return RegistryResult.ALREADY_REGISTERED;
        }
        if (Stream.economy != null) {
            Stream.economy.unhookEconomy();
        }
        Stream.economy = economy;
        return RegistryResult.REGISTERED;
    }
    /**
     * Registers a new style provider to the server
     * @param style style provider
     * @param override true, if the api should override the previous economy, else false
     * @return result
     */
    public static RegistryResult registerStyle(StyleProvider style, boolean override){
        // Make sure the API is usable and the registry allows new registrations
        if (provider == null){
            return RegistryResult.PROVIDER_NOT_REGISTERED;
        } else if (!provider.acceptsNewRegistries()){
            return RegistryResult.REGISTRY_CLOSED;
        }


        if (Stream.style != null && !override){
            return RegistryResult.ALREADY_REGISTERED;
        }
        if (Stream.style != null) {
            Stream.style.unhookStyle();
        }
        Stream.style = style;
        return RegistryResult.REGISTERED;
    }
    /**
     * Registers a new permission provider to the server
     * @param permission permission provider
     * @param override true, if the api should override the previous economy, else false
     * @return result
     */
    public static RegistryResult registerPermission(PermissionProvider permission, boolean override){
        // Make sure the API is usable and the registry allows new registrations
        if (provider == null){
            return RegistryResult.PROVIDER_NOT_REGISTERED;
        } else if (!provider.acceptsNewRegistries()){
            return RegistryResult.REGISTRY_CLOSED;
        }


        if (Stream.permission != null && !override){
            return RegistryResult.ALREADY_REGISTERED;
        }
        if (Stream.permission != null) {
            Stream.permission.unhookPermission();
        }
        Stream.permission = permission;
        return RegistryResult.REGISTERED;
    }

    /**
     * Return results of registering new providers to the server
     */
    public enum RegistryResult {
        /**
         * The provider was registered as the provider of the server
         */
        REGISTERED,
        /**
         * The server already has a provider for the given type and it was not overridden
         */
        ALREADY_REGISTERED,

        /**
         * The server is no longer accepting new registries to the server
         */
        REGISTRY_CLOSED,

        /**
         * The server does not have a Stream API provider!
         */
        PROVIDER_NOT_REGISTERED
    }

}
