package bet.astral.stream.economy;

/**
 * Creates a new currency economy
 * @author Antritus
 * @since 1.0.0
 */
public abstract class CurrencyEconomy extends Economy {
    protected final Currency currency;

    /**
     * Creates a new currency economy instance
     * @param currency currency to use
     */
    protected CurrencyEconomy(Currency currency) {
        this.currency = currency;
    }

    /**
     * Returns the currency used for this economy
     * @return currency
     */
    public Currency getCurrency() {
        return currency;
    }

}
