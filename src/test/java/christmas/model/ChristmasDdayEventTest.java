package christmas.model;

import christmas.model.ChristmasDdayEvent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChristmasDdayEventTest {

    @DisplayName("크리스마스 디데이 할인 계산 테스트")
    @Test
    void calculateChristmasDdayDiscount() {
        LocalDate eventStartDate = LocalDate.of(2023, 12, 1);
        LocalDate eventEndDate = LocalDate.of(2023, 12, 25);
        ChristmasDdayEvent christmasDdayEvent = new ChristmasDdayEvent(true, 0, eventStartDate, eventEndDate);

        LocalDate orderDateBeforeEvent = LocalDate.of(2023, 11, 30);
        int discountBeforeEvent = christmasDdayEvent.calculateChristmasDdayDiscount(orderDateBeforeEvent);
        assertEquals(0, discountBeforeEvent);

        LocalDate orderDateOnEventStart = LocalDate.of(2023, 12, 1);
        int discountOnEventStart = christmasDdayEvent.calculateChristmasDdayDiscount(orderDateOnEventStart);
        assertEquals(ChristmasDdayDiscount.START_AMOUNT.getAmount(), discountOnEventStart);

        LocalDate orderDateDuringEvent = LocalDate.of(2023, 12, 10);
        int expectedDiscountDuringEvent = ChristmasDdayDiscount.START_AMOUNT.getAmount() +
                (int) (10 - 1) * ChristmasDdayDiscount.DAILY_INCREASE.getAmount();
        int discountDuringEvent = christmasDdayEvent.calculateChristmasDdayDiscount(orderDateDuringEvent);
        assertEquals(expectedDiscountDuringEvent, discountDuringEvent);

        LocalDate orderDateAfterEvent = LocalDate.of(2023, 12, 26);
        int discountAfterEvent = christmasDdayEvent.calculateChristmasDdayDiscount(orderDateAfterEvent);
        assertEquals(0, discountAfterEvent);
    }
}