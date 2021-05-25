package dk.BrugtMarket.resource.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateUserAdvertisementDTO {
    private final String advertisement;

    @JsonCreator
    public CreateUserAdvertisementDTO(@JsonProperty("advertisement") String advertisement) {
        this.advertisement = advertisement;
    }

    public String getAdvertisement() {
        return advertisement;
    }

    @Override
    public String toString() {
        return "CreateUserAdvertisement{" +
                "user='" + advertisement + '\'' +
                '}';
    }
}
