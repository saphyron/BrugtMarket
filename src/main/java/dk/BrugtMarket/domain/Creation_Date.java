package dk.BrugtMarket.domain;

import java.util.Date;

public class Creation_Date {

    private final Date date;

    public Creation_Date(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Creation_Date{" +
                "date=" + date +
                '}';
    }
}
