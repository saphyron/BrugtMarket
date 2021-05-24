package dk.BrugtMarket.repository.entity;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;

@Entity
@Table(name = "City")
@NamedQueries({
        @NamedQuery(name = "CityPO.findAll", query = "Select q from CityPO q")
})

public class CityPO {

    public static final String FIND_ALL = "CityPO.findAll";

    @Id
    @Column(name = "ZIP_CODE")
    @XmlElement(name = "zipCode", required = true)
    private String zipCode;

    @Column(name = "CITY")
    @XmlElement(name = "city", required = true)
    private String city;

    @OneToOne(mappedBy = "city")
    private Ad_UserPO userPO;

    public CityPO(String zipCode, String city) {
        this.zipCode = zipCode;
        this.city = city;
    }

    public CityPO() {
    }

    public void setUser(Ad_UserPO userPO) {
        this.userPO = userPO;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }

    public Ad_UserPO getUserPO() {
        return userPO;
    }

    @Override
    public String toString() {
        return "CityPO{" +
                "zipCode='" + zipCode + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
