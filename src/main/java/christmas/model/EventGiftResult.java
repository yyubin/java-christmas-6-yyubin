package christmas.model;

public class EventGiftResult {
    private final boolean isGiftGiven;
    private final EventGift eventGift;

    public EventGiftResult(boolean isGiftGiven, EventGift eventGift) {
        this.isGiftGiven = isGiftGiven;
        this.eventGift = eventGift;
    }

    public boolean isGiftGiven() {
        return isGiftGiven;
    }

    public EventGift getEventGift() {
        return eventGift;
    }

    public static EventGiftResult giftGiven(EventGift eventGift) {
        return new EventGiftResult(true, eventGift);
    }

    public static EventGiftResult noGiftGiven() {
        return new EventGiftResult(false, EventGift.NO_GIFT);
    }
}
