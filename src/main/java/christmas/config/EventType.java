package christmas.config;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public enum EventType {
    CHRISTMAS_DDAY("크리스마스 디데이 할인", LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 25)),
    WEEKDAY_DISCOUNT("평일 할인", LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 31)),
    WEEKEND_DISCOUNT("주말 할인", LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 31)),
    SPECIAL_DISCOUNT("특별 할인", LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 31)),
    GIFT_EVENT("증정 이벤트", LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 31)),
    NONE("없음", LocalDate.of(1900, 1, 1), LocalDate.of(2999, 12, 31));

    private final String eventName;
    private final LocalDate startDate;
    private final LocalDate endDate;

    EventType(String eventName, LocalDate startDate, LocalDate endDate) {
        this.eventName = eventName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getEventName() {
        return eventName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public static List<EventType> getAllEventTypes() {
        return Arrays.asList(values());
    }
}
