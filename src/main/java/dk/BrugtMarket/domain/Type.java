package dk.BrugtMarket.domain;

public class Type {

    private final String type;

    public Type(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Type{" +
                "type='" + type + '\'' +
                '}';
    }
}
