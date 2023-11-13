package christmas.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpecialDiscountEventTest {

    @Test
    @DisplayName("일반 날짜의 할인 계산 테스트")
    void testCalculateSpecialDiscount_RegularDay() {
        LocalDate regularDate = LocalDate.of(2023, Month.DECEMBER, 15);
        SpecialDiscountEvent discount = SpecialDiscountEvent.calculateSpecialDiscount(regularDate);
        assertEquals(SpecialDiscountEvent.NONE, discount);
    }

    @Test
    @DisplayName("토요일의 할인 계산 테스트")
    void testCalculateSpecialDiscount_Saturday() {
        LocalDate saturdayDate = LocalDate.of(2023, Month.DECEMBER, 16);
        SpecialDiscountEvent discount = SpecialDiscountEvent.calculateSpecialDiscount(saturdayDate);
        assertEquals(SpecialDiscountEvent.CALENDAR_STAR, discount);
    }

    @Test
    @DisplayName("크리스마스 날의 할인 계산 테스트")
    void testCalculateSpecialDiscount_ChristmasDay() {
        LocalDate christmasDate = LocalDate.of(2023, Month.DECEMBER, 25);
        SpecialDiscountEvent discount = SpecialDiscountEvent.calculateSpecialDiscount(christmasDate);
        assertEquals(SpecialDiscountEvent.CALENDAR_STAR, discount);
    }
}