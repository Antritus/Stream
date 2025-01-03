package bet.astral.text.api.component;

/**
 * @author antritus
 * @since 1.0.5
 */
public class BasicComponent implements Component{
    private final String value;
    private final boolean isText;

    public BasicComponent(String value, boolean isText) {
        this.value = value;
        this.isText = isText;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public boolean isLanguage() {
        return !isText;
    }

    @Override
    public boolean isText() {
        return isText;
    }
}
