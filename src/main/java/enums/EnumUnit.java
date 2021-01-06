package enums;

public enum  EnumUnit {
    ADET("Adet"),
    KILOGRAM("Kilogram"),
    METRE("Metre"),
    BOY("Boy"),
    LITRE("Litre");

    private final String unit;

    EnumUnit(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }
}
