package christmas.model;

import java.time.DayOfWeek;
import java.time.LocalDate;

public enum WeekEvent {
    WEEKDAY_DISCOUNT("평일 할인", MenuType.DESSERT, 2023),
    WEEKEND_DISCOUNT("주말 할인", MenuType.MAIN, 2023);

    private String eventName;
    private MenuType eventMenuType;
    private Integer discountAmount;

    WeekEvent(String eventName, MenuType eventMenuType, Integer discountAmount) {
        this.eventName = eventName;
        this.eventMenuType = eventMenuType;
        this.discountAmount = discountAmount;
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
