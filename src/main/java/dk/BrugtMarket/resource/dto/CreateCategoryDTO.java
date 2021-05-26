package dk.BrugtMarket.resource.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class CreateCategoryDTO {

    private String category;
    private List<CreateAdvertisementDTO> advertisements;

    @JsonCreator
    public CreateCategoryDTO(
            @JsonProperty("category") String category,
            @JsonProperty("advertisements") ArrayList<CreateAdvertisementDTO> advertisements
    ) {
        this.category = category;
        this.advertisements = advertisements;
    }

    public String getCategory() {
        return category;
    }

    public List<CreateAdvertisementDTO> getAdvertisements() {
        return advertisements;
    }

    @Override
    public String toString() {
        return "CreateCategoryDTO{" +
                "category='" + category + '\'' +
                ", advertisements=" + advertisements +
                '}';
    }
}
