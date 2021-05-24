package dk.BrugtMarket.repository.entity;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "AD_USER")
@NamedQueries({
        @NamedQuery(name = "Ad_UserPO.findAll", query = "Select q from Ad_UserPO q"),
        @NamedQuery(name = "Ad_UserPO.findByQID", query = "Select q from Ad_UserPO q where q.id=:QID")
})

public class Ad_UserPO {

    public static final String FIND_ALL = "Ad_UserPO.findAll";
    public static final String QID_PARAMETER = "QID";
    public static final String FIND_BY_QID = "Ad_UserPO.findByQID";

    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    @Column(name = "ID", columnDefinition = "VARCHAR(40)", nullable = false, updatable = false, unique = true)
    private UUID id;

    @Column(name = "FIRST_NAME", columnDefinition = "VARCHAR(30)", nullable = false)
    @XmlElement(name = "firstName", required = true)
    private String firstName;

    @Column(name = "LAST_NAME", columnDefinition = "VARCHAR(30)", nullable = false)
    @XmlElement(name = "lastName", required = true)
    private String lastName;

    @Column(name = "COMPANY_NAME", columnDefinition = "VARCHAR(40)")
    @XmlElement(name = "companyName", required = true)
    private String companyName;

    @Column(name = "PHONE_NUMBER", columnDefinition = "VARCHAR(20)", nullable = false)
    @XmlElement(name = "phoneNumber", required = true)
    private String phoneNumber;

    @Column(name = "PHONE_CODE", columnDefinition = "VARCHAR(10)", nullable = false)
    @XmlElement(name = "phoneCode", required = true)
    private String phoneCode;

    @Column(name = "EMAIL", columnDefinition = "VARCHAR(100)", nullable = false, unique = true)
    @XmlElement(name = "email", required = true)
    private String email;

    @Column(name = "CREATION_DATE", columnDefinition = "date", nullable = false)
    @XmlElement(name = "creationDate", required = true)
    private Date creationDate;

    @OneToOne
    @JoinColumn(name = "city_fk", referencedColumnName = "ZIP_CODE", nullable = false)
    private CityPO city;

    @Column(name = "TYPE", columnDefinition = "VARCHAR(10)", nullable = false)
    @XmlElement(name = "type", required = true)
    private String type;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<AdvertisementPO> advertisements;

    public Ad_UserPO(
            String firstName, String lastName, String companyName,
            String phoneNumber, String phoneCode, String email,
            Date creationDate, CityPO city, String type) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyName = companyName;
        this.phoneNumber = phoneNumber;
        this.phoneCode = phoneCode;
        this.email = email;
        this.creationDate = creationDate;
        this.city = city;
        city.setUser(this);
        this.type = type;
        this.advertisements = new ArrayList<>();
    }

    public Ad_UserPO() {
    }

    public UUID getId() {
        return id;
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

    public Date getCreationDate() {
        return creationDate;
    }

    public CityPO getCity() {
        return city;
    }

    public String getType() {
        return type;
    }

    public List<AdvertisementPO> getAdvertisements() {
        if (advertisements == null) {
            advertisements = new ArrayList<>();
        }
        return advertisements;
    }

    public void addAdvertisement(AdvertisementPO advertisementPO) {
        advertisementPO.setUser(this);
        getAdvertisements().add(advertisementPO);
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Ad_UserPO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", phoneCode='" + phoneCode + '\'' +
                ", email='" + email + '\'' +
                ", creationDate=" + creationDate +
                ", city=" + city +
                ", type='" + type + '\'' +
                '}';
    }
}
