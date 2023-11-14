package christmas.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChristmasDdayEventTest {

    @Test
    void calculateChristmasDdayDiscount_NotApply_ReturnsZero() {
        LocalDate orderDate = LocalDate.of(2023, 12, 15);
        ChristmasDdayEvent event = new ChristmasDdayEvent(false,
                LocalDate.of(2023, 12, 1),
                LocalDate.of(2023, 12, 25));

        int result = event.calculateChristmasDdayDiscount(orderDate);

        assertEquals(0, result);
    }

    @Test
    void calculateChristmasDdayDiscount_BeforeStartDate_ReturnsZero() {
        LocalDate orderDate = LocalDate.of(2023, 11, 30);
        ChristmasDdayEvent event = new ChristmasDdayEvent(true,
                LocalDate.of(2023, 12, 1),
                LocalDate.of(2023, 12, 25));

        int result = event.calculateChristmasDdayDiscount(orderDate);

        assertEquals(0, result);
    }

    @Test
    void calculateChristmasDdayDiscount_AfterEndDate_ReturnsZero() {
        LocalDate orderDate = LocalDate.of(2023, 12, 26);
        ChristmasDdayEvent event = new ChristmasDdayEvent(true,
                LocalDate.of(2023, 12, 1),
                LocalDate.of(2023, 12, 25));


        int result = event.calculateChristmasDdayDiscount(orderDate);

        assertEquals(0, result);
    }

    @Test
    void calculateChristmasDdayDiscount_OnStartDate_ReturnsStartAmount() {
        LocalDate orderDate = LocalDate.of(2023, 12, 1);
        ChristmasDdayEvent event = new ChristmasDdayEvent(true,
                LocalDate.of(2023, 12, 1),
                LocalDate.of(2023, 12, 25));

        int result = event.calculateChristmasDdayDiscount(orderDate);

        assertEquals(ChristmasDdayDiscount.START_AMOUNT.getAmount(), result);
    }

    @Test
    void calculateChristmasDdayDiscount_InBetweenStartDateAndEndDate_ReturnsCorrectAmount() {
        LocalDate orderDate = LocalDate.of(2023, 12, 10);
        ChristmasDdayEvent event = new ChristmasDdayEvent(true,
                LocalDate.of(2023, 12, 1),
                LocalDate.of(2023, 12, 25));

        int result = event.calculateChristmasDdayDiscount(orderDate);

        int expectedDiscount = ChristmasDdayDiscount.START_AMOUNT.getAmount()
                + ChristmasDdayDiscount.DAILY_INCREASE.getAmount() * 9;
        assertEquals(expectedDiscount, result);
    }
}