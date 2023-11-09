package christmas.model;

public enum EventGift {
    CHAMPAGNE("샴페인", 1, 25000),
    NO_GIFT("상품없음", 0, 0);

    private final String giftName;
    private final int giftCount;
    private final int giftAmount;

    EventGift(String giftName, int giftAmount, int giftAmount1) {
        this.giftName = giftName;
        this.giftCount = giftAmount;
        this.giftAmount = giftAmount1;
    }

    public String getGiftName() {
        return giftName;
    }

    public int getGiftCount() {
        return giftCount;
    }

    public int getGiftAmount() {
        return giftAmount;
    }
}
