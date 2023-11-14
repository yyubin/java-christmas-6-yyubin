package christmas.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpecialDiscountEventTest {

    @Test
    void calculateSpecialDiscount_Saturday_ReturnsCalendarStarDiscount() {
        LocalDate saturday = LocalDate.of(2023, Month.DECEMBER, 23); // Saturday

        SpecialDiscountEvent result = SpecialDiscountEvent.calculateSpecialDiscount(saturday);

        assertEquals(SpecialDiscountEvent.CALENDAR_STAR, result);
    }

    @Test
    void calculateSpecialDiscount_NotSaturdayOrChristmas_ReturnsNoneDiscount() {
        LocalDate weekday = LocalDate.of(2023, Month.DECEMBER, 18); // Monday

        SpecialDiscountEvent result = SpecialDiscountEvent.calculateSpecialDiscount(weekday);

        assertEquals(SpecialDiscountEvent.NONE, result);
    }

    @Test
    void calculateSpecialDiscount_ChristmasDay_ReturnsCalendarStarDiscount() {
        LocalDate christmas = LocalDate.of(2023, Month.DECEMBER, 25);

        SpecialDiscountEvent result = SpecialDiscountEvent.calculateSpecialDiscount(christmas);

        assertEquals(SpecialDiscountEvent.CALENDAR_STAR, result);
    }
}
