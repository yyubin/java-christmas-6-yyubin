package christmas.config;

public enum DdayDiscountAmount {
    START_AMOUNT(1000),
    DAILY_INCREASE(100);

    private final int amount;

    DdayDiscountAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
