package dk.BrugtMarket.domain;

public class Sales_Type {
    private final String type;

    public Sales_Type(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Sales_Type{" +
                "type='" + type + '\'' +
                '}';
    }
}
