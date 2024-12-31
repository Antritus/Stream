package bet.astral.stream.permission;

import bet.astral.stream.utils.Group;
import bet.astral.stream.utils.TriState;

/**
 * Permission manager of a stream
 * @author Antritus
 * @since 1.0.0
 */
public abstract class Permission {
    /**
     * Returns true if permissions like "permission.*" are supported
     * @return true if supported, else false
     */
    public abstract boolean supportsAsteriskPermissions();

    /**
     * Returns true if the permission manager supports permission groups
     * @return true if supported, else false
     */
    public abstract boolean supportsGroups();

    /**
     * Sets the setting value of a permission for a player to given state. NOT_SET to unset the permission
     * @param playerId player id
     * @param permission permission
     * @param triState state
     */
    public abstract void setPermission(String playerId, String permission, TriState triState);

    /**
     * Sets the setting value of a permission for a player to given state. To unset permission use {@link #setPermission(String, String, TriState)}
     * @param playerId player
     * @param permission permission
     * @param state state, true to allow, else false to deny
     */
    public abstract void setPermission(String playerId, String permission, boolean state);

    /**
     * Sets the permission of a permission for a player if the player does not have the permission.
     * @param playerId player id
     * @param permission permission
     * @param state state
     */
    public abstract void setPermissionIfAbsent(String playerId, String permission, TriState state);
    /**
     * Sets the permission of a permission for a player if the player does not have the permission.
     * @param playerId player id
     * @param permission permission
     * @param state state, true to allow, else false to deny
     */
    public abstract void setPermissionIfAbsent(String playerId, String permission, boolean state);

    /**
     * Returns true if the player has the given permission
     * @param playerId player
     * @param permission permission
     * @return true, else false
     */
    public abstract boolean hasPermission(String playerId, String permission);
    /**
     * Returns the player's permission value. If permission value is {@link TriState#NOT_SET}, else returns the given permission
     * @param playerId player
     * @param permission permission
     * @return permission value, else give default state
     */
    public abstract TriState hasPermission(String playerId, String permission, TriState defaultValue);

    /**
     * Returns the player's permission value. If permission value is {@link TriState#NOT_SET}, else returns the given permission
     * @param playerId player
     * @param permission permission
     * @return permission value, else give default state
     */
    public abstract boolean hasPermission(String playerId, String permission, boolean defaultValue);

    /**
     * Returns the groups of the permission manager
     * @return permission groups
     */
    public abstract Group[] getGroups();

    /**
     * Returns the groups which this player is a part of
     * @param playerId player id
     * @return groups
     */
    public abstract Group[] getPlayerGroups(String playerId);
    /**
     * Returns the parent groups of the given group id
     * @param groupId group id
     * @return parent groups
     */
    public abstract Group[] getParentGroups(String groupId);

    /**
     * Sets the permission value of the group to given state. To unset use {@link TriState#NOT_SET}
     * @param groupId group id
     * @param permission permission
     * @param triState {@link TriState#TRUE} to allow, {@link TriState#FALSE} to deny, {@link TriState#NOT_SET} to unset
     */
    public abstract void setPermissionGroup(String groupId, String permission, TriState triState);

    /**
     * Sets the permission value of the group to given to the given state. To unset use {@link #setPermissionGroup(String, String, TriState)}
     * @param groupId group id
     * @param permission permission
     * @param state true to allow, false to deny
     */
    public abstract void setPermissionGroup(String groupId, String permission, boolean state);

    /**
     * Sets the permission value of the group given to the given value if the permission is not found in the group's permissions
     * @param groupId group id
     * @param permission permission
     * @param state state
     */
    public abstract void setPermissionIfAbsentGroup(String groupId, String permission, TriState state);
    /**
     * Sets the permission value of the group given to the given value if the permission is not found in the group's permissions
     * @param groupId group id
     * @param permission permission
     * @param state state
     */
    public abstract void setPermissionIfAbsentGroup(String groupId, String permission, boolean state);

    /**
     * Returns true if the group has the given permission
     * @param groupId group id
     * @param permission permission
     * @return true, if the group has the given permission, else false
     */
    public abstract boolean hasPermissionGroup(String groupId, String permission);

    /**
     * Returns the current state of the group. If the permission is not set on the group returns the default value
     * @param groupId group id
     * @param permission permission
     * @param defaultValue default value (returned if not set)
     * @return state, else default value
     */
    public abstract TriState hasPermissionGroup(String groupId, String permission, TriState defaultValue);

    /**
     * Returns the current state of the group. If the permission is not set on the group returns the default value
     * @param groupId group id
     * @param permission permission
     * @param defaultValue default value (returned if not set)
     * @return state, else default value
     */
    public abstract boolean hasPermissionGroup(String groupId, String permission, boolean defaultValue);
}
