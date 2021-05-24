package dk.BrugtMarket.domain;

public class Price {

    private final int price;

    public Price(int price) {
        if (price < 0) {
            this.price = 0;
        } else {
            this.price = price;
        }
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Price{" +
                "price=" + price +
                '}';
    }
}
