package dk.BrugtMarket.resource.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class ReadAdvertisementDTO {

    private String type;
    private String headline;
    private String text;
    private int price;
    private Date creation;

    public ReadAdvertisementDTO( String type, String headline, String text, int price, Date creation) {
        this.type = type;
        this.headline = headline;
        this.text = text;
        this.price = price;
        this.creation = creation;
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
        return "ReadAdvertisementDTO{" +
                ", type='" + type + '\'' +
                ", headline='" + headline + '\'' +
                ", text='" + text + '\'' +
                ", price=" + price +
                ", creation=" + creation +
                '}';
    }
}
