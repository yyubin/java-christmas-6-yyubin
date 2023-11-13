package christmas.util;

import christmas.validator.MenuValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MenuValidatorTest {

    @Test
    @DisplayName("주문 항목 유효성 검사 테스트 - 올바른 주문")
    void validateOrderEntry_ValidOrder() {
        List<String> validOrder = List.of("티본스테이크", "3");

        assertDoesNotThrow(() -> MenuValidator.validateOrderEntry(validOrder));
    }

    @Test
    @DisplayName("주문 항목 유효성 검사 테스트 - 파싱 실패")
    void validateOrderEntry_FailParsing() {
        List<String> invalidOrder = List.of("티본스테이크", "-", "3");

        assertThrows(IllegalArgumentException.class, () -> MenuValidator.validateOrderEntry(invalidOrder));
    }

    @Test
    @DisplayName("주문 항목 유효성 검사 테스트 - 메뉴에 없는 메뉴 주문")
    void validateOrderEntry_NonExistMenu() {
        List<String> invalidOrder = List.of("스테이크", "3");

        assertThrows(IllegalArgumentException.class, () -> MenuValidator.validateOrderEntry(invalidOrder));
    }

    @Test
    @DisplayName("주문 항목 유효성 검사 테스트 - 메뉴 이름 누락")
    void validateOrderEntry_MissingMenuName() {
        List<String> invalidOrder = List.of("3");

        assertThrows(IllegalArgumentException.class, () -> MenuValidator.validateOrderEntry(invalidOrder));
    }

    @Test
    @DisplayName("주문 항목 유효성 검사 테스트 - 잘못된 수량")
    void validateOrderEntry_InvalidQuantity() {
        List<String> invalidOrder = List.of("피자", "abc");

        assertThrows(IllegalArgumentException.class, () -> MenuValidator.validateOrderEntry(invalidOrder));
    }

}
