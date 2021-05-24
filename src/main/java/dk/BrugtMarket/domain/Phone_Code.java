package dk.BrugtMarket.domain;

public class Phone_Code {

    private final String code;

    public Phone_Code(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Phone_Code{" +
                "code='" + code + '\'' +
                '}';
    }
}
