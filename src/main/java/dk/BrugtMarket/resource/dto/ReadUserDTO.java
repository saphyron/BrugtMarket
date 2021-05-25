package dk.BrugtMarket.resource.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

public class ReadUserDTO {

    private String firstName;
    private String lastName;
    private String companyName;
    private String phoneNumber;
    private String phoneCode;
    private String email;
    private Date creation;
    private List<AdvertisementDTO> advertisements;
    private CityDTO city;
    private String type;

    public ReadUserDTO(String firstName, String lastName, String companyName,
                       String phoneNumber, String phoneCode, String email,
                       Date creation, List<AdvertisementDTO> advertisements,
                       CityDTO city, String type) {
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

    public List<AdvertisementDTO> getAdvertisements() {
        return advertisements;
    }

    public CityDTO getCity() {
        return city;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "ReadUserDTO{" +
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
