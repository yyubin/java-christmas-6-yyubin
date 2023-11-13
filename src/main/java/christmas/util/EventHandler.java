package christmas.util;

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

    public List<BenefitDetail> calculateBenefits(LocalDate orderDate, List<OrderMenu> orderMenus, int totalOrderAmount) {
        List<BenefitDetail> benefitDetails = new ArrayList<>();

        benefitDetails.add(calculateChristmasDdayEvent(orderDate));
        benefitDetails.add(calculateWeekEvent(orderDate, orderMenus));
        benefitDetails.add(calculateSpecialDiscount(orderDate));
        benefitDetails.add(calculateEventGiftAmount(orderDate, totalOrderAmount));

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
        SpecialDiscountEvent specialDiscountEvent = SpecialDiscountEvent.calculateSpecialDiscount(orderDate);
        if (isApplyEvent(orderDate, EventType.SPECIAL_DISCOUNT) && isSpecialDiscountNone(specialDiscountEvent)) {
            return new BenefitDetail(EventType.SPECIAL_DISCOUNT, specialDiscountEvent.getDiscountAmount());
        }
        return new BenefitDetail(EventType.NONE, 0);
    }

    public boolean isSpecialDiscountNone(SpecialDiscountEvent specialDiscountEvent) {
        return specialDiscountEvent != SpecialDiscountEvent.NONE;
    }

    private int calculateWeekEventAmount(List<OrderMenu> orderMenus, WeekEvent applydWeekEvent) {
        int discountAmount = 0;
        for (OrderMenu orderMenu: orderMenus) {
            if (orderMenu.getMenu().getType() == applydWeekEvent.getEventMenuType()) {
                discountAmount += applydWeekEvent.getDiscountAmount() * orderMenu.getQuantity();
            }
        }
        return discountAmount;
    }

    private WeekEvent pickWeekdayEventOrWeekendEvent(LocalDate orderDate) {
        return WeekEvent.getDayOfWeek(orderDate);
    }

    public BenefitDetail calculateEventGiftAmount(LocalDate orderDate, int totalOrderAmount) {
        if (isApplyEvent(orderDate, EventType.GIFT_EVENT)) {
            EventGiftResult eventGiftResult = calculateEventGift(totalOrderAmount);
            if (eventGiftResult.isGiftGiven()) {
                return new BenefitDetail(EventType.GIFT_EVENT, eventGiftResult.getEventGift().getGiftAmount());
            }
        }
        return new BenefitDetail(EventType.NONE, 0);
    }

    public EventGiftResult calculateEventGift(int totalOrderAmount) {
        if (totalOrderAmount >= TotalOrderAmount.EVENT_GIFT_THRESHOLD.getAmount()) {
            return EventGiftResult.giftGiven(EventGift.CHAMPAGNE);
        }
        return EventGiftResult.noGiftGiven();
    }

    public int calculateTotalBenefitsAmount(List<BenefitDetail> benefitDetails) {
        int totalBenefitsAmount = 0;
        for (BenefitDetail benefitDetail: benefitDetails) {
            totalBenefitsAmount += benefitDetail.getBenefitAmount();
        }
        return totalBenefitsAmount;
    }
}
