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

    public List<BenefitDetail> calculateBenefits(LocalDate orderDate, List<OrderMenu> orderMenus) {
        List<BenefitDetail> benefitDetails = new ArrayList<>();
        benefitDetails.add(calculateChristmasDdayEvent(orderDate));
        benefitDetails.add(calculateWeekEvent(orderDate, orderMenus));
        benefitDetails.add(calculateSpecialDiscount(orderDate));
        return benefitDetails;
    }

    private boolean isApplyEvent(LocalDate orderDate, EventType eventType) {
        if (orderDate.isBefore(eventType.getStartDate()) || orderDate.isAfter(eventType.getEndDate())) {
            return false;
        }
        return true;
    }

    public BenefitDetail calculateChristmasDdayEvent(LocalDate orderDate) {
        if (isApplyEvent(orderDate, EventType.CHRISTMAS_DDAY)) {
            ChristmasDdayEvent christmasDdayEvent = new ChristmasDdayEvent(true, EventType.CHRISTMAS_DDAY.getStartDate(), EventType.CHRISTMAS_DDAY.getEndDate());
            int christmasDdayEventAmount = christmasDdayEvent.calculateChristmasDdayDiscount(orderDate);
            return new BenefitDetail(EventType.CHRISTMAS_DDAY, christmasDdayEventAmount);
        }
        return new BenefitDetail(EventType.NONE, 0);
    }

    public BenefitDetail calculateWeekEvent(LocalDate orderDate, List<OrderMenu> orderMenus) {
        if (isApplyEvent(orderDate, EventType.WEEKDAY_DISCOUNT) && isApplyEvent(orderDate, EventType.WEEKEND_DISCOUNT)) {
            WeekEvent weekEvent = pickWeekdayEventOrWeekendEvent(orderDate);
            int discountAmount = calculateWeekEventAmount(orderMenus, weekEvent);
            return new BenefitDetail(weekEvent.getEventType(), discountAmount);
        }
        return new BenefitDetail(EventType.NONE, 0);
    }

    public BenefitDetail calculateSpecialDiscount(LocalDate orderDate) {
        if (isApplyEvent(orderDate, EventType.SPECIAL_DISCOUNT)) {
            SpecialDiscountEvent specialDiscountEvent = SpecialDiscountEvent.calculateSpecialDiscount(orderDate);
            return new BenefitDetail(EventType.SPECIAL_DISCOUNT, specialDiscountEvent.getDiscountAmount());
        }
        return new BenefitDetail(EventType.NONE, 0);
    }

    private int calculateWeekEventAmount(List<OrderMenu> orderMenus, WeekEvent applydWeekEvent) {
        int discountAmount = 0;
        for (OrderMenu orderMenu: orderMenus) {
            if (orderMenu.getMenu().getType() == applydWeekEvent.getEventMenuType()) {
                discountAmount += applydWeekEvent.getDiscountAmount();
            }
        }
        return discountAmount;
    }



    private WeekEvent pickWeekdayEventOrWeekendEvent(LocalDate orderDate) {
        return WeekEvent.getDayOfWeek(orderDate);
    }
}
