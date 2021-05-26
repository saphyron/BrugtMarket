package dk.BrugtMarket.repository.entity;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Category")
@NamedQueries({
        @NamedQuery(name = "CategoryPO.distinctCategory", query = "select c from CategoryPO c")
})
public class CategoryPO {

    public static final String FIND_CATEGORIES = "CategoryPO.distinctCategory";

    @Id
    @Column(name = "category", columnDefinition = "VARCHAR(40)", nullable = false, unique = true)
    @XmlElement(name = "category", required = true)
    private String category;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<AdvertisementPO> advertisement;

    public CategoryPO(String category) {
        this.category = category;
    }

    public CategoryPO() {
    }

    public String getCategory() {
        return category;
    }

    public List<AdvertisementPO> getAdvertisement() {
        if (advertisement == null) {
            advertisement = new ArrayList<>();
        }
        return advertisement;
    }

    public void addAdvertisement(AdvertisementPO advertisement) {
        advertisement.setCategory(this);
        getAdvertisement().add(advertisement);
    }

    @Override
    public String toString() {
        return "CategoryPO{" +
                "category='" + category + '\'' +
                ", advertisement=" + advertisement +
                '}';
    }
}
