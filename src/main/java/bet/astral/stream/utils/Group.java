package bet.astral.stream.utils;

import bet.astral.stream.permission.NodeCache;
import bet.astral.stream.style.Metadata;

import java.util.List;

/**
 * Default group of the server
 * @author Antritus
 * @since 1.0.0
 */
public interface Group {
    /**
     * Returns the members of this group
     * @return members
     */
    List<String> getMembers();

    /**
     * Returns the metadata of this group
     * @return metadata
     */
    Metadata getMetadata();

    /**
     * Returns the permission node cache of this node
     * @return permission cache
     */
    NodeCache getCachedNodes();

    /**
     * Returns the parents of this group
     * @return parents of this group
     */
    Group[] getParents();

    /**
     * Returns true if {@link #getMetadata()} is supported on this group
     * @return supported, else false
     */
    boolean supportMetadata();

    /**
     * Returns true if {@link #getCachedNodes()} is supported on this group
     * @return supported, else false
     */
    boolean supportsCachedNodes();

    /**
     * Returns true if {@link #getParents()} has entries
     * @return supported, else false
     */
    boolean hasParentGroups();
}
