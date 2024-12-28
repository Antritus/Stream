package bet.astral.stream.economy;

import bet.astral.stream.utils.Identifier;
import bet.astral.text.api.component.Component;

/**
 * Currency of an economy
 * @author Antritus
 * @since 1.0.0
 */
public class Currency {
    /**
     * The default economy used in the server
     */
    public static final Currency DEFAULT = new Currency(Identifier.of("stream", "default"), "dollars", "dollar", "$");
    private final Identifier identifier;
    private final Component plural;
    private final Component singular;
    private final Component symbol;

    /**
     * Creates a new instance of a currency
     * @param identifier the identifier (ex: stream:example)
     * @param plural plural form of the currency (dollars, euros)
     * @param singular singular from of the currency (dollar, euro)
     * @param symbol symbol of the currency ($, €)
     */
    public Currency(Identifier identifier, String plural, String singular, String symbol) {
        this(identifier,
                Component.text(plural),
                Component.text(singular),
                Component.text(symbol)
        );
    }
    /**
     * Creates a new instance of a currency
     * @param identifier the identifier (ex: stream:example)
     * @param plural plural form of the currency (dollars, euros)
     * @param singular singular from of the currency (dollar, euro)
     * @param symbol symbol of the currency ($, €)
     */
    public Currency(Identifier identifier, Component plural, Component singular, Component symbol) {
        this.identifier = identifier;
        this.plural = plural;
        this.singular = singular;
        this.symbol = symbol;
    }

    /**
     * Returns the identifier of this currency
     * @return identifier
     */
    public Identifier getIdentifier() {
        return identifier;
    }

    /**
     * Returns the plural name of this currency (dollars, euros)
     * @return plural form
     */
    public Component getNamePlural() {
        return plural;
    }
    /**
     * Returns the plural name of this currency (dollars, euros)
     * @return plural form
     */
    public String getNamePluralString() {
        return plural.getValue();
    }

    /**
     * Returns the singular name of this currency (dollar, euro)
     * @return singular form
     */
    public Component getNameSingular(){
        return singular;
    }
    /**
     * Returns the singular name of this currency (dollar, euro)
     * @return singular form
     */
    public String getNameSingularString(){
        return singular.getValue();
    }

    /**
     * Returns the symbol of this currency ($, €)
     * @return symbol
     */
    public Component getSymbol() {
        return symbol;
    }
    /**
     * Returns the symbol of this currency ($, €)
     * @return symbol
     */
    public String getSymbolString() {
        return symbol.getValue();
    }
}
