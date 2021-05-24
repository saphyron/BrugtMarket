package dk.BrugtMarket.domain;

public class Zip_Code {

    private final String zip;

    public Zip_Code(String zip) {
        this.zip = zip;
    }

    public String getZip() {
        return zip;
    }

    @Override
    public String toString() {
        return "Zip_Code{" +
                "zip='" + zip + '\'' +
                '}';
    }
}
