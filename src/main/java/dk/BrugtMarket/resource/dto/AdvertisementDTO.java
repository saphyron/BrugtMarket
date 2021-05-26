package dk.BrugtMarket.resource.dto;

import dk.BrugtMarket.domain.*;

import java.util.Date;

public class AdvertisementDTO {

    private String id;
    private String type;
    private String headline;
    private String text;
    private int price;
    private Date creation;

    public AdvertisementDTO(
            String id, String type,
            String headline, String text, int price,
            Date creation
    ) {
        this.id = id;
        this.type = type;
        this.headline = headline;
        this.text = text;
        this.price = price;
        this.creation = creation;
    }

    public String getId() {
        return id;
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
}
