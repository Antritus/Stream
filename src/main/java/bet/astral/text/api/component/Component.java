package bet.astral.text.api.component;

import bet.astral.stream.provider.StreamProvider;

/**
 * Text component. Has no other functionality than returning text currently.
 * In the future, hopefully will support more ways to modify text
 * <br><b>This is subject to change when my component library is ready</b>
 * @author Antritus
 * @since 1.0.0
 */
public interface Component {
    /**
     * Returns the value of this component
     * @return value
     */
    String getValue();


    /**
     * Creates a new component instance with the given text
     * @param text text
     * @return new component
     */
    static Component text(String text) {
        return StreamProvider.createText(text);
    }

    /**
     * Creates a new component instance with the given text
     * @param translationKey text
     * @return new component
     */
    static Component lang(String translationKey) {
        return StreamProvider.createLang(translationKey);
    }

    /**
     * Converts throwable to a text component. Hopefully in the future the stacktrace can be put in to a hover component
     * @param throwable throwable
     * @return component
     */
    static Component throwable(Throwable throwable){
        return throwable::getMessage;
    }
}
