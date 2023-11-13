package christmas.model;

public enum ChristmasDdayDiscount {
    START_AMOUNT(1000),
    DAILY_INCREASE(100);

    private final int amount;

    ChristmasDdayDiscount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
