package dk.BrugtMarket.resource.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateUserCityDTO {
    private final String user;

    @JsonCreator
    public CreateUserCityDTO(@JsonProperty("user") String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "CreateUserCity{" +
                "user='" + user + '\'' +
                '}';
    }
}
