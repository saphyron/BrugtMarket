package dk.BrugtMarket.resource.dto;

import java.util.List;

public class ReadCategoryDTO {

    private String category;
    private List<AdvertisementDTO> advertisements;

    public ReadCategoryDTO(String category, List<AdvertisementDTO> advertisements) {
        this.category = category;
        this.advertisements = advertisements;
    }

    public String getCategory() {
        return category;
    }

    public List<AdvertisementDTO> getAdvertisements() {
        return advertisements;
    }

    @Override
    public String toString() {
        return "ReadCategoryDTO{" +
                "category='" + category + '\'' +
                ", advertisements=" + advertisements +
                '}';
    }
}
