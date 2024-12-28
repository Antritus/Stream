package bet.astral.stream.permission;

import bet.astral.stream.utils.TriState;

/**
 * @author Antritus
 * @since 1.0.0
 */
public interface NodeCache {
    void setPermission(String permission, TriState triState);
    void setPermission(String permission, boolean state);
    void setPermissionIfAbsent(String permission, TriState state);
    void setPermissionIfAbsent(String permission, boolean state);

    boolean hasPermission(String permission);
    TriState hasPermission(String permission, TriState defaultValue);
    boolean hasPermission(String permission, boolean defaultValue);

    NodeCache getParent();
    void setParent(NodeCache cache);
}
