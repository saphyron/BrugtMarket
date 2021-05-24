package dk.BrugtMarket.repository.entity;

import dk.BrugtMarket.domain.Category;
import dk.BrugtMarket.domain.Sales_Type;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "ADVERTISEMENT")
@NamedQueries({
        @NamedQuery(name = "AdvertisementPO.findAll", query = "Select q from AdvertisementPO q"),
        @NamedQuery(name = "AdvertisementPO.findByQID", query = "Select q from AdvertisementPO q where q.id=:QID")
})

public class AdvertisementPO {

    public static final String FIND_ALL = "AdvertisementPO.findAll";
    public static final String QID_PARAMETER = "QID";
    public static final String FIND_BY_QID = "AdvertisementPO.findByQID";

    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    @Column(name = "ID", columnDefinition = "VARCHAR(40)", nullable = false, updatable = false, unique = true)
    private UUID id;

    @Column(name = "CATEGORY", columnDefinition = "VARCHAR(40)", nullable = false)
    @XmlElement(name = "category", required = true)
    private Category category;

    @Column(name = "SALES_TYPE", columnDefinition = "VARCHAR(40)", nullable = false)
    @XmlElement(name = "salesType", required = true)
    private Sales_Type salesType;

    @Column(name = "HEADLINE", columnDefinition = "VARCHAR(40)", nullable = false)
    @XmlElement(name = "headline", required = true)
    private String headline;

    @Column(name = "TEXT", columnDefinition = "VARCHAR(1000)", nullable = false)
    @XmlElement(name = "text", required = true)
    private String text;

    @Column(name = "PRICE", columnDefinition = "int", nullable = false)
    @XmlElement(name = "price", required = true)
    private int price;

    @ManyToOne()
    @JoinColumn(name = "user", nullable = false)
    private Ad_UserPO userPO;

    @Column(name = "CREATION_DATE", columnDefinition = "date", nullable = false)
    @XmlElement(name = "creationDate", required = true)
    private Date creationDate;

    public AdvertisementPO(Category category, Sales_Type salesType, String headline, String text, int price, Date creationDate) {
        this.category = category;
        this.salesType = salesType;
        this.headline = headline;
        this.text = text;
        this.price = price;
        this.creationDate = creationDate;
    }

    public AdvertisementPO() {
    }

    public UUID getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public Sales_Type getSalesType() {
        return salesType;
    }

    public String getHeadline() {
        return headline;
    }

    public String getText() {
        return text;
    }

    public int getPrice() {
        return price;
    }

    public Ad_UserPO getUserPO() {
        return userPO;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setSalesType(Sales_Type salesType) {
        this.salesType = salesType;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setUser(Ad_UserPO userPO) {

        this.userPO = userPO;
    }


}
