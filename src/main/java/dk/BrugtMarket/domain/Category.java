package dk.BrugtMarket.domain;

import java.util.List;

public class Category {

    private final String category;
    private final List<Advertisement> advertisement;

    public Category(String category, List<Advertisement> advertisement) {
        this.category = category;
        this.advertisement = advertisement;
    }

    public String getCategory() {
        return category;
    }

    public List<Advertisement> getAdvertisement() {
        return advertisement;
    }

    public Advertisement findAdvertisement (Id advertisementId) {
        return advertisement.stream().filter(a-> a.getId().equals(advertisementId)).findFirst().orElse(null);
    }

    @Override
    public String toString() {
        return "Category{" +
                "category='" + category + '\'' +
                ", advertisement=" + advertisement +
                '}';
    }
}
