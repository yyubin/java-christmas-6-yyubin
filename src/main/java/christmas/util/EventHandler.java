package christmas.util;

import christmas.config.EventDate;
import christmas.config.TotalOrderAmount;
import christmas.model.EventGift;
import christmas.model.EventGiftEvent;
import christmas.model.OrderMenu;
import christmas.model.WeekEvent;

import java.time.LocalDate;
import java.util.List;

public class EventHandler {

    public int calculateTotalOrderAmount(List<OrderMenu> orderMenus) {
        int totalAmount = 0;
        for (OrderMenu order : orderMenus) {
            totalAmount += order.getMenu().getPrice() * order.getQuantity();
        }
        return totalAmount;
    }

    public EventGiftEvent calculateEventGift(int totalOrderAmount) {
        if (totalOrderAmount >= TotalOrderAmount.EVENT_GIFT_THRESHOLD.getAmount()) {
            return EventGiftEvent.giftGiven(EventGift.CHAMPAGNE);
        }
        return EventGiftEvent.noGiftGiven();
    }

    public WeekEvent calculateWeekEvent(Integer eventDay) {
        return WeekEvent.getDayOfWeek(LocalDate.of(
                EventDate.DECEMBER_2023.getEventYear(),
                EventDate.DECEMBER_2023.getEventMonth(),
                eventDay));
    }
}
