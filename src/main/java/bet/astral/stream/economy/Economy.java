package bet.astral.stream.economy;

import bet.astral.stream.annotations.ASync;
import bet.astral.stream.annotations.Sync;
import bet.astral.stream.economy.vault.Vault;
import bet.astral.stream.economy.vault.VaultBuilder;
import bet.astral.text.api.component.Component;

import java.util.concurrent.CompletableFuture;

/**
 * Economy provided by an economy provider
 * @author Antritus
 * @since 1.0.0
 */
public abstract class Economy implements EconomyWrapperPlayer {
    @Override
    public final Economy wrapper() {
        return this;
    }

    /**
     * Returns true if this economy does not exist anymore (or is unhooked)
     * @return true if does not exist
     */
    public abstract boolean exists();
    /**
     * Returns true if vaults are enabled by the provider
     * @return true if enabled
     */
    public abstract boolean areVaultsEnabled();

    /**
     * Returns true if vaults with multiple players are enabled by the provider
     * @return true if enabled
     */
    public abstract boolean areMultiPlayerVaultsEnabled();

    /**
     * Returns the balance of the player
     * @param playerId player
     * @return balance
     */
    @Sync
    public abstract double getBalance(String playerId);

    /**
     * Sets the balance of the given player
     * @param playerId player
     * @param amount new balance
     * @return response
     */
    @Sync
    public abstract Response setBalance(String playerId, double amount);

    /**
     * Adds to the balance of the given player
     * @param playerId player
     * @param amount amount
     * @return response
     */
    @Sync
    public abstract Response addBalance(String playerId, double amount);

    /**
     * Subtracts from the balance of the given player
     * @param playerId player
     * @param amount amount
     * @return response
     */
    @Sync
    public abstract Response subtractBalance(String playerId, double amount);

    /**
     * Resets the balance of the given player
     * @param playerId player
     * @return response
     */
    @Sync
    public abstract Response resetBalance(String playerId);

    /**
     * Returns all the vaults for a given player
     * @param playerId player
     * @return vaults
     * @throws Response non success response
     */
    @Sync
    public abstract Vault[] getPlayerVaults(String playerId) throws Response;

    /**
     * Returns all the vaults for a given player
     * @param playerId player
     * @return vaults
     * @throws Response non success response
     */
    @ASync
    public CompletableFuture<Vault[]> getPlayerVaultsASync(String playerId) throws Response {
        Vault[] vaults = getPlayerVaults(playerId);
        return CompletableFuture.completedFuture(vaults);
    }

    /**
     * Returns true if a vault with given id exists in the server
     * @param vaultId vault id
     * @return true if exists, else false
     * @throws Response non success response
     */
    @Sync
    public abstract boolean doesVaultExist(String vaultId) throws Response;

    /**
     * Asynchronously Returns true if a vault with given id exists in the server
     * @param vaultId vault id
     * @return completable future with true if exists
     * @throws Response non success response
     */
    @ASync
    public CompletableFuture<Boolean> doesVaultExistASync(String vaultId) throws Response {
        boolean exists = doesVaultExist(vaultId);
        return CompletableFuture.completedFuture(exists);
    }

    /**
     * Creates a new vault with the economy provider
     * @return new vault instance
     * @throws Response non success response
     */
    @Sync
    public abstract Vault createVault() throws Response;
    /**
     * Creates a new vault with the economy provider with the vault builder as a helper
     * @return new vault instance
     * @throws Response non success response
     */
    @Sync
    public abstract Vault createVault(VaultBuilder vaultBuilder) throws Response;

    /**
     * Deletes all the given player's vaults
     * @param playerId player
     * @return response
     */
    @Sync
    public abstract Response deletePlayerVaults(String playerId);

    /**
     * Deletes all the player's vaults asynchronously
     * @param playerId player
     * @return response after completion
     */
    @ASync
    public CompletableFuture<Response> deletePlayerVaultsAsync(String playerId){
        Response response = deletePlayerVaults(playerId);
        return CompletableFuture.completedFuture(response);
    }

    /**
     * Deletes all the vaults from the provider
     * @return response
     */
    @Sync
    public abstract Response deleteAllVaults();

    /**
     * Deletes all the vaults from the provider asynchronously
     * @return response
     */
    @ASync
    public CompletableFuture<Response> deleteAllVaultsASync(){
        Response response = deleteAllVaults();
        return CompletableFuture.completedFuture(response);
    }

    /**
     * Returns the vault with given id from the economy provider
     * @param vaultId vault id
     * @return vault
     * @throws Response non success response
     */
    @Sync
    public abstract Vault getVault(String vaultId) throws Response;
    /**
     * Returns the vault with given id from the economy provider asynchronously
     * @param vaultId vault id
     * @return vault
     * @throws Response non success response
     */
    @ASync
    public CompletableFuture<Vault> getVaultASync(String vaultId) throws Response {
        Vault vault = getVault(vaultId);
        return CompletableFuture.completedFuture(vault);
    }

    /**
     * Returns the balance of a vault
     * @param vaultId vault id
     * @return balance
     * @throws Response non success response
     */
    @Sync
    public abstract double getBalanceVault(String vaultId) throws Response;

    /**
     * Sets the balance of a vault
     * @param vaultId vault id
     * @param amount amount
     * @return response
     */
    @Sync
    public abstract Response setVaultBalance(String vaultId, double amount);

    /**
     * Adds to the balance of a vault
     * @param vaultId vault id
     * @param amount amount
     * @return response
     */
    @Sync
    public abstract Response addVaultBalance(String vaultId, double amount);

    /**
     * Subtracts from the balance of a vault
     * @param vaultId vault id
     * @param amount amount
     * @return response
     */
    @Sync
    public abstract Response subtractVaultBalance(String vaultId, double amount);

    /**
     * Resets the balance of a vault
     * @param vaultId vault id
     * @param amount amount
     * @return response
     */
    @Sync
    public abstract Response resetVaultBalance(String vaultId, double amount);

    /**
     * Returns true if the player is a member of the given vault
     * @param vaultId vault id
     * @param playerId player id
     * @return true if a part of the vault
     * @throws Response non success response
     */
    @Sync
    public abstract boolean isPlayerMemberOfVault(String vaultId, String playerId) throws Response;
    /**
     * Returns true async if the player is a member of the given vault asynchronously
     * @param vaultId vault id
     * @param playerId player id
     * @return true async if a part of the vault
     * @throws Response non success response
     */
    @ASync
    public CompletableFuture<Boolean> isPlayerMemberOfVaultASync(String vaultId, String playerId) throws Response {
        boolean isMember = isPlayerMemberOfVault(vaultId, playerId);
        return CompletableFuture.completedFuture(isMember);
    }

    /**
     * Returns the currency of this economy
     * @return currency
     */
    public Currency getCurrency() {
        return Currency.DEFAULT;
    }

    /**
     * Formats the given number with the currency
     * @param amount amount
     * @return formatted
     */
    public abstract Component format(double amount);

    /**
     * Formats the given number with the currency to a string
     * @param amount amount
     * @return formatted
     */
    public String formatString(double amount) {
        return format(amount).getValue();
    }

    /**
     * Returns the plural form of the currency
     * @return plural form
     */
    public Component getCurrencyPlural() {
        return getCurrency().getNamePlural();
    }

    /**
     * Returns the plural form of the currency
     * @return plural form
     */
    public String getCurrencyPluralString() {
        return getCurrency().getNamePluralString();
    }

    /**
     * Returns the singular form of the currency
     * @return singular form
     */
    public Component getCurrencySingular() {
        return getCurrency().getNameSingular();
    }

    /**
     * Returns the singular form of the currency
     * @return singular form
     */
    public String getCurrencySingularString() {
        return getCurrency().getNameSingularString();
    }

    /**
     * Returns the symbol of the currency
     * @return singular form
     */
    public Component getCurrencySymbol() {
        return getCurrency().getSymbol();
    }

    /**
     * Returns the symbol of the currency
     * @return singular form
     */
    public String getCurrencySymbolString() {
        return getCurrency().getSymbolString();
    }
}
