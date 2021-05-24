package dk.BrugtMarket.domain;

public class Advertisement {

    private final Id id;
    private final Category category;
    private final Sales_Type type;
    private final Headline headline;
    private final Text text;
    private final Price price;
    private final Ad_User user;
    private final Creation_Date creation;

    public Advertisement(
            Id id, Category category, Sales_Type type,
            Headline headline, Text text, Price price,
            Ad_User user, Creation_Date creation
            ) {
        this.id = id;
        this.category = category;
        this.type = type;
        this.headline = headline;
        this.text = text;
        this.price = price;
        this.user = user;
        this.creation = creation;
    }

    public Id getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public Sales_Type getType() {
        return type;
    }

    public Headline getHeadline() {
        return headline;
    }

    public Text getText() {
        return text;
    }

    public Price getPrice() {
        return price;
    }

    public Ad_User getUser() {
        return user;
    }

    public Creation_Date getCreation() {
        return creation;
    }

    @Override
    public String toString() {
        return "Advertisement{" +
                "id=" + id +
                ", category=" + category +
                ", type=" + type +
                ", headline=" + headline +
                ", text=" + text +
                ", price=" + price +
                ", user=" + user +
                ", creation=" + creation +
                '}';
    }
}
