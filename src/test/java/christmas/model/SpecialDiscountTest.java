package christmas.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpecialDiscountTest {

    @Test
    @DisplayName("일반 날짜의 할인 계산 테스트")
    void testCalculateSpecialDiscount_RegularDay() {
        LocalDate regularDate = LocalDate.of(2023, Month.DECEMBER, 15);
        SpecialDiscount discount = SpecialDiscount.calculateSpecialDiscount(regularDate);
        assertEquals(SpecialDiscount.NONE, discount);
    }

    @Test
    @DisplayName("토요일의 할인 계산 테스트")
    void testCalculateSpecialDiscount_Saturday() {
        LocalDate saturdayDate = LocalDate.of(2023, Month.DECEMBER, 16);
        SpecialDiscount discount = SpecialDiscount.calculateSpecialDiscount(saturdayDate);
        assertEquals(SpecialDiscount.CALENDAR_STAR, discount);
    }

    @Test
    @DisplayName("크리스마스 날의 할인 계산 테스트")
    void testCalculateSpecialDiscount_ChristmasDay() {
        LocalDate christmasDate = LocalDate.of(2023, Month.DECEMBER, 25);
        SpecialDiscount discount = SpecialDiscount.calculateSpecialDiscount(christmasDate);
        assertEquals(SpecialDiscount.CALENDAR_STAR, discount);
    }
}