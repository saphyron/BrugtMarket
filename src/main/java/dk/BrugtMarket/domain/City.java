package dk.BrugtMarket.domain;

public class City {

    private final String city;
    private final Zip_Code zip;

    public City(String city, Zip_Code zip) {
        this.city = city;
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public Zip_Code getZip() {
        return zip;
    }

    @Override
    public String toString() {
        return "City{" +
                "city='" + city + '\'' +
                ", zip=" + zip +
                '}';
    }
}
