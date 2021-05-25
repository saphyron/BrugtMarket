package dk.BrugtMarket.domain;

public class Advertisement {

    private final Id id;
    private final Category category;
    private final Sales_Type type;
    private final Headline headline;
    private final Text text;
    private final Price price;
    private final Creation_Date creation;

    public Advertisement(
            Id id, Category category, Sales_Type type,
            Headline headline, Text text, Price price,
            Creation_Date creation
            ) {
        this.id = id;
        this.category = category;
        this.type = type;
        this.headline = headline;
        this.text = text;
        this.price = price;
        this.creation = creation;
    }

    public Advertisement(
            Category category, Sales_Type type,
            Headline headline, Text text, Price price,
            Creation_Date creation
    ) {
        this.id = null;
        this.category = category;
        this.type = type;
        this.headline = headline;
        this.text = text;
        this.price = price;
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
                ", creation=" + creation +
                '}';
    }
}
