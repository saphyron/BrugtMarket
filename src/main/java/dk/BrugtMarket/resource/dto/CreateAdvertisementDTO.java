package dk.BrugtMarket.resource.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class CreateAdvertisementDTO {

    private String category;
    private String type;
    private String headline;
    private String text;
    private int price;
    private Date creation;

    @JsonCreator
    public CreateAdvertisementDTO(
            @JsonProperty("category") String category,
            @JsonProperty("type") String type,
            @JsonProperty("headline") String headline,
            @JsonProperty("text") String text,
            @JsonProperty("price") int price,
            @JsonProperty("creation") Date creation
    ) {
        this.category = category;
        this.type = type;
        this.headline = headline;
        this.text = text;
        this.price = price;
        this.creation = creation;
    }


    public String getCategory() {
        return category;
    }

    public String getType() {
        return type;
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

    public Date getCreation() {
        return creation;
    }

    @Override
    public String toString() {
        return "CreateAdvertisementDTO{" +
                "category='" + category + '\'' +
                ", type='" + type + '\'' +
                ", headline='" + headline + '\'' +
                ", text='" + text + '\'' +
                ", price=" + price +
                ", creation=" + creation +
                '}';
    }
}
