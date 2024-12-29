package bet.astral.stream.economy;

/**
 * Returns the economy provider of the server
 * @author Antritus
 * @since 1.0.0
 */
public interface EconomyProvider {
    /**
     * Returns the global economy
     * @return global economy
     */
    Economy getEconomy();

    /**
     * Returns the given currencies global economy
     * @param currency currency
     * @return global economy of the given currency
     */
    CurrencyEconomy getEconomy(Currency currency);

    /***
     * Registers a new global economy with the given currency
     * @param currency currency
     */
    void registerEconomy(Currency currency);

    /**
     * Returns the economy of the given world
     * @param worldId world
     * @return economy
     */
    Economy getEconomy(String worldId);

    /**
     * Returns the economy provided for given currency in the given world
     * @param currency currency
     * @param worldId world id
     * @return economy
     */
    CurrencyEconomy getEconomy(Currency currency, String worldId);

    /**
     * Registers the economy of given currency in the given world
     * @param currency currency
     * @param worldId world
     */
    void registerEconomy(Currency currency, String worldId);

    /**
     * Unhooks the economy provider from the stream api
     */
    void unhookEconomy();
}
