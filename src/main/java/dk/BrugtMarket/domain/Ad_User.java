package dk.BrugtMarket.domain;

import java.util.List;

public class Ad_User {

    private final Id id;
    private final First_Name first;
    private final Last_Name last;
    private final Company_Name company;
    private final Phone_Number phone;
    private final Phone_Code phc;
    private final Email email;
    private final Creation_Date creation;
    private final List<Advertisement> advertisements;
    private final City city;
    private final Type type;

    public Ad_User(
            First_Name first, Last_Name last, Company_Name company,
            Phone_Number phone, Phone_Code phc, Email email,
            Creation_Date creation, List<Advertisement> advertisements,
            City city, Type type
            ) {
        this.id = null;
        this.first = first;
        this.last = last;
        this.company = company;
        this.phone = phone;
        this.phc = phc;
        this.email = email;
        this.creation = creation;
        this.advertisements = advertisements;
        this.city = city;
        this.type = type;
    }

    public Ad_User(
            Id id, First_Name first, Last_Name last, Company_Name company,
            Phone_Number phone, Phone_Code phc, Email email,
            Creation_Date creation, List<Advertisement> advertisements,
            City city, Type type
    ) {
        this.id = id;
        this.first = first;
        this.last = last;
        this.company = company;
        this.phone = phone;
        this.phc = phc;
        this.email = email;
        this.creation = creation;
        this.advertisements = advertisements;
        this.city = city;
        this.type = type;
    }

    public Id getId() {
        return id;
    }

    public First_Name getFirst() {
        return first;
    }

    public Last_Name getLast() {
        return last;
    }

    public Company_Name getCompany() {
        return company;
    }

    public Phone_Number getPhone() {
        return phone;
    }

    public Phone_Code getPhc() {
        return phc;
    }

    public Email getEmail() {
        return email;
    }

    public Creation_Date getCreation() {
        return creation;
    }

    public List<Advertisement> getAdvertisements() {
        return advertisements;
    }

    public City getCity() {
        return city;
    }

    public Type getType() {
        return type;
    }

    public Advertisement findAdvertisement (Id advertisementId) {
        return advertisements.stream().filter(a-> a.getId().equals(advertisementId)).findFirst().orElse(null);
    }

    @Override
    public String toString() {
        return "Ad_User{" +
                "id=" + id +
                ", first=" + first +
                ", last=" + last +
                ", company=" + company +
                ", phone=" + phone +
                ", phc=" + phc +
                ", email=" + email +
                ", creation=" + creation +
                ", advertisements=" + advertisements +
                ", city=" + city +
                ", type=" + type +
                '}';
    }
}
