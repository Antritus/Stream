package bet.astral.stream.permission;

import bet.astral.stream.utils.Group;
import bet.astral.stream.utils.TriState;

/**
 * @author Antritus
 * @since 1.0.0
 */
public abstract class Permission {
    public abstract boolean supportsAsteriskPermissions();
    public abstract boolean supportsGroups();

    public abstract void setPermission(String playerId, String permission, TriState triState);
    public abstract void setPermission(String playerId, String permission, boolean state);
    public abstract void setPermissionIfAbsent(String playerId, String permission, TriState state);
    public abstract void setPermissionIfAbsent(String playerId, String permission, boolean state);
    public abstract boolean hasPermission(String playerId, String permission);
    public abstract TriState hasPermission(String playerId, String permission, TriState defaultValue);
    public abstract boolean hasPermission(String playerId, String permission, boolean defaultValue);

    public abstract Group[] getGroups();
    public abstract Group[] getPlayerGroups(String playerId);
    public abstract Group[] getParentGroups(String groupId);

    public abstract void setPermissionGroup(String groupId, String permission, TriState triState);
    public abstract void setPermissionGroup(String groupId, String permission, boolean state);
    public abstract void setPermissionIfAbsentGroup(String groupId, String permission, TriState state);
    public abstract void setPermissionIfAbsentGroup(String groupId, String permission, boolean state);
    public abstract boolean hasPermissionGroup(String groupId, String permission);
    public abstract TriState hasPermissionGroup(String groupId, String permission, TriState defaultValue);
    public abstract boolean hasPermissionGroup(String groupId, String permission, boolean defaultValue);
}
