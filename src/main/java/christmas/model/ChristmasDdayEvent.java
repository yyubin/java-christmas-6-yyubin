package christmas.model;

import java.time.LocalDate;

public class ChristmasDdayEvent {

    private final boolean isApply;
    private final LocalDate eventStartDate;
    private final LocalDate eventEndDate;

    public ChristmasDdayEvent(boolean isApply, LocalDate eventStartDate, LocalDate eventEndDate) {
        this.isApply = isApply;
        this.eventStartDate = eventStartDate;
        this.eventEndDate = eventEndDate;
    }

    public boolean isApply() {
        return isApply;
    }

    public int calculateChristmasDdayDiscount(LocalDate orderDate) {
        if (!isApply) {
            return 0;
        }
        if (orderDate.isBefore(eventStartDate) || orderDate.isAfter(eventEndDate)) {
            return 0;
        }
        return calculateChristmasDdayDiscountAmount(orderDate);
    }

    private Integer calculateChristmasDdayDiscountAmount(LocalDate orderDate) {
        long daysBetween = eventStartDate.datesUntil(orderDate).count();
        int dailyDiscount = ChristmasDdayDiscount.DAILY_INCREASE.getAmount() * (int) daysBetween;
        return dailyDiscount + ChristmasDdayDiscount.START_AMOUNT.getAmount();
    }
}
