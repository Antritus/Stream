package bet.astral.stream.utils;

import bet.astral.stream.Stream;
import bet.astral.text.api.component.Component;

import java.util.LinkedList;
import java.util.List;

/**
 * Player reference
 * @author Antritus
 * @since 1.0.0
 */
public interface Player {
    /**
     * Returns the player id
     * @return player id
     */
    String getId();

    /**
     * Sends the given component as a message to the player
     * @param message the message component
     */
    void sendMessage(Component... message);
    /**
     * Sends the given component as a message to the player
     * @param message the message component
     */
    default void sendMessageWithSpaces(Component... message) {
        final Component space = Component.text(" ");
        List<Component> componentList = new LinkedList<>();
        for (Component component : message){
            componentList.add(component);
            if (componentList.size()!=1){
                componentList.add(space);
            }
        }
        if (componentList.size() != 1){
            componentList.remove(componentList.lastIndexOf(space));
        }
        sendMessage(componentList.toArray(Component[]::new));
    }

    /**
     * Sends the given component as a message to the player
     * @param message the message component
     */
    default void sendMessage(Component message) {
        sendMessage(new Component[]{message});
    }
    /**
     * Sends the given text as a text component to the player
     * @param message the message
     */
    default void sendMessage(String message) {
        sendMessage(Component.text(message));
    }

    /**
     * Returns true if the player has the permission given or if stream does not provide permission handler returns true
     * @param permission permission
     * @return true if has permission, else false
     */
    default boolean hasPermission(String permission){
        if (Stream.getPermission() != null) {
            return Stream.getPermission().hasPermission(this.getId(), permission);
        }
        return true;
    }

    /**
     * Returns true/false if has the permission else, returns NOT_SET
     * @param permission permission
     * @return true/false/not_set
     */
    default TriState hasPermissionTriState(String permission){
        if ( Stream.getPermission() != null) {
            return Stream.getPermission().hasPermission(this.getId(), permission, TriState.FALSE);
        }
        return TriState.NOT_SET;
    }
}
