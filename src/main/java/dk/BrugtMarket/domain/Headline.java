package dk.BrugtMarket.domain;

public class Headline {

    private final String headline;

    public Headline(String headline) {
        this.headline = headline;
    }

    public String getHeadline() {
        return headline;
    }

    @Override
    public String toString() {
        return "Headline{" +
                "headline='" + headline + '\'' +
                '}';
    }
}
