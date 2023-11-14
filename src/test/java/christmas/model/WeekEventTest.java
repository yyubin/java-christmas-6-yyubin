package christmas.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeekEventTest {
    @Test
    void getDayOfWeek_Weekday_ReturnsWeekdayDiscountEvent() {
        LocalDate weekday = LocalDate.of(2023, 12, 18); // Monday

        WeekEvent result = WeekEvent.getDayOfWeek(weekday);

        assertEquals(WeekEvent.WEEKDAY_DISCOUNT, result);
    }

    @Test
    void getDayOfWeek_Weekend_ReturnsWeekendDiscountEvent() {
        LocalDate weekend = LocalDate.of(2023, 12, 23); // Saturday

        WeekEvent result = WeekEvent.getDayOfWeek(weekend);

        assertEquals(WeekEvent.WEEKEND_DISCOUNT, result);
    }

    @Test
    void getDayOfWeek_Sunday_ReturnsWeekendDiscountEvent() {
        LocalDate sunday = LocalDate.of(2023, 12, 24); // Sunday

        WeekEvent result = WeekEvent.getDayOfWeek(sunday);

        assertEquals(WeekEvent.WEEKEND_DISCOUNT, result);
    }

    @Test
    void getDayOfWeek_Saturday_ReturnsWeekendDiscountEvent() {
        LocalDate saturday = LocalDate.of(2023, 12, 30); // Saturday

        WeekEvent result = WeekEvent.getDayOfWeek(saturday);

        assertEquals(WeekEvent.WEEKEND_DISCOUNT, result);
    }

}
