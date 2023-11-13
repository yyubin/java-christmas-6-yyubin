package christmas.model;

import christmas.config.EventType;

import java.time.DayOfWeek;
import java.time.LocalDate;

public enum WeekEvent {
    WEEKDAY_DISCOUNT(EventType.WEEKDAY_DISCOUNT, MenuType.DESSERT, 2023),
    WEEKEND_DISCOUNT(EventType.WEEKEND_DISCOUNT, MenuType.MAIN, 2023);

    private final EventType eventType;
    private final MenuType eventMenuType;
    private final Integer discountAmount;

    WeekEvent(EventType eventType, MenuType eventMenuType, Integer discountAmount) {
        this.eventType = eventType;
        this.eventMenuType = eventMenuType;
        this.discountAmount = discountAmount;
    }

    public EventType getEventType() {
        return eventType;
    }

    public MenuType getEventMenuType() {
        return eventMenuType;
    }

    public Integer getDiscountAmount() {
        return discountAmount;
    }

    public static WeekEvent getDayOfWeek(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();

        if (isWeekday(dayOfWeek)) {
            return WEEKDAY_DISCOUNT;
        }
        return WEEKEND_DISCOUNT;
    }

    private static boolean isWeekday(DayOfWeek dayOfWeek) {
        return dayOfWeek != DayOfWeek.SATURDAY && dayOfWeek != DayOfWeek.SUNDAY;
    }
}
