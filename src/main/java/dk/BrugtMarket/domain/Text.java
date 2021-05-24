package dk.BrugtMarket.domain;

public class Text {

    private final String text;

    public Text(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Text{" +
                "text='" + text + '\'' +
                '}';
    }
}
