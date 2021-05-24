package dk.BrugtMarket.resource.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CreateUserDTO {

    private String firstName;
    private String lastName;
    private String companyName;
    private String phoneNumber;
    private String phoneCode;
    private String email;
    private Date creation;
    private List<CreateAdvertisementDTO> advertisements;
    private CreateCityDTO city;
    private String type;

    @JsonCreator
    public CreateUserDTO(
            @JsonProperty("firstName") String firstName,
            @JsonProperty("lastName") String lastName,
            @JsonProperty("companyName") String companyName,
            @JsonProperty("phoneNumber") String phoneNumber,
            @JsonProperty("phoneCode") String phoneCode,
            @JsonProperty("email") String email,
            @JsonProperty("creation") Date creation,
            @JsonProperty("advertisements")ArrayList<CreateAdvertisementDTO> advertisements,
            @JsonProperty("city") CreateCityDTO city,
            @JsonProperty("type") String type
            ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyName = companyName;
        this.phoneNumber = phoneNumber;
        this.phoneCode = phoneCode;
        this.email = email;
        this.creation = creation;
        this.advertisements = advertisements;
        this.city = city;
        this.type = type;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public String getEmail() {
        return email;
    }

    public Date getCreation() {
        return creation;
    }

    public List<CreateAdvertisementDTO> getAdvertisements() {
        return advertisements;
    }

    public CreateCityDTO getCity() {
        return city;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "CreateUserDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", phoneCode='" + phoneCode + '\'' +
                ", email='" + email + '\'' +
                ", creation=" + creation +
                ", advertisements=" + advertisements +
                ", city=" + city +
                ", type='" + type + '\'' +
                '}';
    }
}
