package christmas.config;

public enum DiscountAmount {
    START_AMOUNT(1000),
    DAILY_INCREASE(100);

    private final int amount;

    DiscountAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
