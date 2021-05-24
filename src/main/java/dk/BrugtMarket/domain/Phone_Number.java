package dk.BrugtMarket.domain;

public class Phone_Number {

    private final String number;

    public Phone_Number(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Phone_Number{" +
                "number='" + number + '\'' +
                '}';
    }
}
