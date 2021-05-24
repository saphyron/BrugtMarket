package dk.BrugtMarket.resource.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateCityDTO {

    private String city;
    private String zipCode;

    @JsonCreator
    public CreateCityDTO(
            @JsonProperty("city") String city,
            @JsonProperty("zipCode") String zipCode
    ) {
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
        return "CreateCityDTO{" +
                "city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
