package bet.astral.stream.economy.vault;

import bet.astral.stream.utils.Player;

import java.util.LinkedList;
import java.util.List;

/**
 * Vault builder to help with vault creation within the economy provider
 * @author Antritus
 * @since 1.0.0
 */
public class VaultBuilder {
    private final List<String> members = new LinkedList<>();
    private String id;
    private double balance = 0;

    /**
     * Sets the id of the vault
     * @param vaultId vault id
     * @return this
     */
    public VaultBuilder setId(String vaultId){
        this.id = vaultId;
        return this;
    }

    /**
     * Adds a member to the vault
     * @param memberId member id
     * @return this
     */
    public VaultBuilder addMember(String memberId) {
        if (memberId == null){
            return this;
        }
        this.members.add(memberId);
        return this;
    }
    /**
     * Adds a member to the vault
     * @param member member
     * @return this
     */
    public VaultBuilder addPlayer(Player member) {
        if (member == null){
            return this;
        }
        this.members.add(member.getId());
        return this;
    }

    /**
     * Adds given members to the vault
     * @param members members
     * @return this
     */
    public VaultBuilder addMembers(List<String> members){
        if (members == null || members.isEmpty()){
            return this;
        }
        this.members.addAll(members);
        return this;
    }
    /**
     * Adds given members to the vault
     * @param members members
     * @return this
     */
    public VaultBuilder addPlayers(List<Player> members){
        if (members == null || members.isEmpty()){
            return this;
        }
        this.members.addAll(members.stream().map(Player::getId).toList());
        return this;
    }

    /**
     * Sets the default balance of the vault
     * @param balance balance
     * @return this
     */
    public VaultBuilder setBalance(double balance){
        this.balance = balance;
        return this;
    }

    /**
     * Returns the members of this vault
     * @return members
     */
    public List<String> getMembers() {
        return members;
    }

    /**
     * Returns the id of this vault
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * Returns the default balance of this vault
     * @return balance
     */
    public double getBalance() {
        return balance;
    }
}
