package bet.astral.stream.economy.vault;

import bet.astral.stream.economy.Economy;
import bet.astral.stream.economy.Response;

import java.util.LinkedList;
import java.util.List;

/**
 * Vault or a bank
 * @author Antritus
 * @since 1.0.0
 */
public abstract class Vault {
    protected final Economy economy;
    protected final String id;
    protected final List<String> members;
    protected double balance;

    /**
     * Creates a new instance of a vault
     * @param economy economy (where this is from)
     * @param id id
     * @param members members
     * @param balance balance
     */
    public Vault(Economy economy, String id, List<String> members, double balance) {
        this.economy = economy;
        this.id = id;
        this.members = members;
        this.balance = balance;
    }

    /**
     * Creates a new instance of a vault
     * @param economy economy
     * @param owner owner
     * @param id id
     * @param balance balance
     */
    public Vault(Economy economy, String owner, String id, double balance) {
        this.economy = economy;
        this.balance = balance;
        this.members = new LinkedList<>();
        this.members.add(owner);
        this.id = id;
    }

    /**
     * Returns the balance of this vault
     * @return balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Returns the id of this vault
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * Returns the members of this vault
     * @return members
     */
    public List<String> getMembers() {
        return members;
    }

    /**
     * Returns the economy this was provided from
     * @return economy
     */
    public Economy getEconomy() {
        if (!economy.exists()){
            throw new IllegalStateException("The vault providing vault " + getId() + " does not exist!");
        }
        return economy;
    }

    /**
     * Returns true if this vault exists within it's economy provider
     * @return true if exists, else false
     * @throws Response response, not implemented or error or failure
     */
    public boolean exists() throws Response {
        if (!economy.exists()){
            throw new IllegalStateException("The vault providing vault " + getId() + " does not exist!");
        }
        return economy.doesVaultExist(getId());
    }

    /**
     * Subtracts given amount from the vault's balance
     * @param amount amount
     * @return response
     */
    public abstract Response subtract(double amount);

    /**
     * Adds given amount to the vault's balance
     * @param amount amount
     * @return response
     */
    public abstract Response add(double amount);
    /**
     * Sets the vault's balance to given amount
     * @param amount amount
     * @return response
     */
    public abstract Response set(double amount);

    /**
     * Resets the vault's balance to 0
     * @return response
     */
    public abstract Response reset();
}
