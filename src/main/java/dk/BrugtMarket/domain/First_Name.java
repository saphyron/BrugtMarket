package dk.BrugtMarket.domain;

public class First_Name {

    private final String name;

    public First_Name(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "First_Name{" +
                "name='" + name + '\'' +
                '}';
    }
}
