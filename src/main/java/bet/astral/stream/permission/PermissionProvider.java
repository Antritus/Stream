package bet.astral.stream.permission;

/**
 * Permission provider of the server
 * @author Antritus
 * @since 1.0.0
 */
public interface PermissionProvider {
    /**
     * Returns the global permission manager
     * @return global permissions
     */
    Permission getPermission();

    /**
     * Returns the per world permission manager for the given world
     * @param worldId world
     * @return world
     */
    Permission getPermissionFromWorld(String worldId);

    /**
     * Unhooks the permission manager from the stream api
     */
    void unhookPermission();
}
