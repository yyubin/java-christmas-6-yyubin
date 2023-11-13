package christmas.util;

import christmas.config.EventDate;
import christmas.config.EventType;
import christmas.config.TotalOrderAmount;
import christmas.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
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

    public List<BenefitDetail> calculateBenefits(LocalDate orderDate) {
        List<BenefitDetail> benefitDetails = new ArrayList<>();
        benefitDetails.add(calculateChristmasDdayEvent(orderDate));

        return benefitDetails;
    }

    public BenefitDetail calculateChristmasDdayEvent(LocalDate orderDate) {
        if (isApplyEvent(orderDate, EventType.CHRISTMAS_DDAY)) {
            ChristmasDdayEvent christmasDdayEvent = new ChristmasDdayEvent(true, EventType.CHRISTMAS_DDAY.getStartDate(), EventType.CHRISTMAS_DDAY.getEndDate());
            int christmasDdayEventAmount = christmasDdayEvent.calculateChristmasDdayDiscount(orderDate);
            return new BenefitDetail(EventType.CHRISTMAS_DDAY, christmasDdayEventAmount);
        }
        return new BenefitDetail(EventType.CHRISTMAS_DDAY, 0);
    }

    public boolean isApplyEvent(LocalDate orderDate, EventType eventType) {
        if (orderDate.isBefore(eventType.getStartDate()) || orderDate.isAfter(eventType.getEndDate())) {
            return false;
        }
        return true;
    }

    public WeekEvent calculateWeekEvent(Integer eventDay) {
        return WeekEvent.getDayOfWeek(LocalDate.of(
                EventDate.DECEMBER_2023.getEventYear(),
                EventDate.DECEMBER_2023.getEventMonth(),
                eventDay));
    }
}
