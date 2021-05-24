package dk.BrugtMarket.domain;

public class Last_Name {

    private final String name;

    public Last_Name(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Last_Name{" +
                "name='" + name + '\'' +
                '}';
    }
}
