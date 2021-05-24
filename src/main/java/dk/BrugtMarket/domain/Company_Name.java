package dk.BrugtMarket.domain;

public class Company_Name {
    private final String name;

    public Company_Name(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Company_Name{" +
                "name='" + name + '\'' +
                '}';
    }
}
