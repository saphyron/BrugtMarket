package dk.BrugtMarket.resource.dto;

import dk.BrugtMarket.domain.Zip_Code;

public class CityDTO {

    private String city;
    private String zip;

    public CityDTO(String city, String zip) {
        this.city = city;
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public String getZip() {
        return zip;
    }
}
