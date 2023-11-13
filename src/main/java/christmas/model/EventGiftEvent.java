package christmas.model;

public class EventGiftEvent {
    private final boolean isGiftGiven;
    private final EventGift eventGift;

    public EventGiftEvent(boolean isGiftGiven, EventGift eventGift) {
        this.isGiftGiven = isGiftGiven;
        this.eventGift = eventGift;
    }

    public boolean isGiftGiven() {
        return isGiftGiven;
    }

    public EventGift getEventGift() {
        return eventGift;
    }

    public static EventGiftEvent giftGiven(EventGift eventGift) {
        return new EventGiftEvent(true, eventGift);
    }

    public static EventGiftEvent noGiftGiven() {
        return new EventGiftEvent(false, EventGift.NO_GIFT);
    }
}
