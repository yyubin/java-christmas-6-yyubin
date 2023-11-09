package christmas.config;

public enum TotalOrderAmount {
    MIN_AMOUNT(10000),
    EVENT_GIFT_THRESHOLD(120000);

    private final int amount;

    TotalOrderAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
