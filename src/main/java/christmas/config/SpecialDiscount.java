package christmas.config;

public enum SpecialDiscount {
    CALENDAR_STAR("특별 할인", 1000);

    private final String discountName;
    private final int discountAmount;

    SpecialDiscount(String discountName, int discountAmount) {
        this.discountName = discountName;
        this.discountAmount = discountAmount;
    }

    public String getDiscountName() {
        return discountName;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }
}
