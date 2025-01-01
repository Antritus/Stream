package bet.astral.stream.economy;

/**
 * Currency economy interface. Cast this class to {@link Economy}
 * @author Antritus
 * @since 1.0.0
 */
public interface CurrencyEconomy {
    /**
     * Returns the currency used for this economy
     * @return currency
     */
    Currency getCurrency();
}

