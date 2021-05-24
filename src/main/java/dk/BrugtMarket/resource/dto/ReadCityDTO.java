package dk.BrugtMarket.resource.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ReadCityDTO {

    private String city;
    private String zipCode;

    public ReadCityDTO(String city, String zipCode) {
        this.city = city;
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    @Override
    public String toString() {
        return "ReadCityDTO{" +
                "city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
