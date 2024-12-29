package bet.astral.stream.economy;

import bet.astral.stream.annotations.ASync;
import bet.astral.stream.annotations.Sync;
import bet.astral.stream.economy.vault.Vault;
import bet.astral.stream.utils.Player;
import bet.astral.text.api.component.Component;

import java.util.concurrent.CompletableFuture;

/**
 * Wrapper to split the economy to two files instead of one big one super messy
 * @author Antritus
 * @since 1.0.0
 */
public interface EconomyWrapperPlayer {
    Economy wrapper();

    /**
     * Returns the balance of the player
     * @param player player
     * @return balance
     */
    @Sync
    default double getBalance(Player player) {
        return wrapper().getBalance(player.getId());
    }

    /**
     * Sets the balance of the given player
     * @param player player
     * @param amount new balance
     * @return response
     */
    @Sync
    default Response setBalance(Player player, double amount) {
        return wrapper().setBalance(player.getId(), amount);
    }

    /**
     * Sets the balance of the given player
     * @param player player
     * @param amount new balance
     * @param reason reason for transaction
     * @return response
     */
    @Sync
    default Response setBalance(Player player, double amount, Component reason) {
        return wrapper().setBalance(player.getId(), amount, reason);
    }

    /**
     * Adds to the balance of the given player
     * @param player player
     * @param amount amount
     * @return response
     */
    @Sync
    default Response addBalance(Player player, double amount) {
        return wrapper().addBalance(player.getId(), amount);
    }
    /**
     * Adds to the balance of the given player
     * @param player player
     * @param amount amount
     * @param reason reason for transaction
     * @return response
     */
    @Sync
    default Response addBalance(Player player, double amount, Component reason) {
        return wrapper().addBalance(player.getId(), amount, reason);
    }

    /**
     * Subtracts from the balance of the given player
     * @param player player
     * @param amount amount
     * @return response
     */
    @Sync
    default Response subtractBalance(Player player, double amount) {
        return wrapper().subtractBalance(player.getId(), amount);
    }
    /**
     * Subtracts from the balance of the given player
     * @param player player
     * @param amount amount
     * @param reason reason for transaction
     * @return response
     */
    @Sync
    default Response subtractBalance(Player player, double amount, Component reason) {
        return wrapper().subtractBalance(player.getId(), amount, reason);
    }
    /**
     * Resets the balance of the given player
     * @param player player
     * @return response
     */
    @Sync
    default Response resetBalance(Player player) {
        return wrapper().resetBalance(player.getId());
    }
    /**
     * Resets the balance of the given player
     * @param player player
     * @param reason reason for transaction
     * @return response
     */
    @Sync
    default Response resetBalance(Player player, Component reason) {
        return wrapper().resetBalance(player.getId(), reason);
    }

    /**
     * Returns all the vaults for a given player
     * @param player player
     * @return vaults
     * @throws Response non success response
     */
    @Sync
    default Vault[] getPlayerVaults(Player player) throws Response {
        return wrapper().getPlayerVaults(player.getId());
    }

    /**
     * Returns all the vaults for a given player
     * @param player player
     * @return vaults
     * @throws Response non success response
     */
    @ASync
    default CompletableFuture<Vault[]> getPlayerVaultsASync(Player player) throws Response {
        return wrapper().getPlayerVaultsASync(player.getId());
    }

    /**
     * Deletes all the given player's vaults
     * @param player player
     * @return response
     */
    @Sync
    default Response deletePlayerVaults(Player player) {
        return wrapper().deletePlayerVaults(player.getId());
    }

    /**
     * Deletes all the player's vaults asynchronously
     * @param player player
     * @return response after completion
     */
    @ASync
    default CompletableFuture<Response> deletePlayerVaultsAsync(Player player){
        return wrapper().deletePlayerVaultsAsync(player.getId());
    }

    /**
     * Returns true if the player is a member of the given vault
     * @param vaultId vault id
     * @param player player
     * @return true if a part of the vault
     * @throws Response non success response
     */
    @Sync
    default boolean isPlayerMemberOfVault(String vaultId, Player player) throws Response {
        return wrapper().isPlayerMemberOfVault(vaultId, player.getId());
    }
    /**
     * Returns true async if the player is a member of the given vault asynchronously
     * @param vaultId vault id
     * @param player player
     * @return true async if a part of the vault
     * @throws Response non success response
     */
    @ASync
    default CompletableFuture<Boolean> isPlayerMemberOfVaultASync(String vaultId, Player player) throws Response {
        return wrapper().isPlayerMemberOfVaultASync(vaultId, player.getId());
    }
    
}
