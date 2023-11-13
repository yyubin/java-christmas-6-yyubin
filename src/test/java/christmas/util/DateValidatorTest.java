package christmas.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DateValidatorTest {
    @Test
    @DisplayName("유효한 날짜 검증 테스트")
    void validateValidDate() {
        String validDate = "10";
        int result = DateValidator.validateDate(validDate);
        assertEquals(10, result);
    }

    @Test
    @DisplayName("음수 날짜 검증 실패 테스트")
    void validateNegativeDate() {
        String negativeDate = "-5";
        assertThrows(IllegalArgumentException.class, () -> DateValidator.validateDate(negativeDate));
    }

    @Test
    @DisplayName("숫자가 아닌 값 검증 실패 테스트")
    void validateNonNumericDate() {
        String nonNumericDate = "abc";
        assertThrows(IllegalArgumentException.class, () -> DateValidator.validateDate(nonNumericDate));
    }

    @Test
    @DisplayName("숫자가 아닌 값 파싱 실패 테스트")
    void parseNonNumericDate() {
        String nonNumericDate = "abc";
        assertThrows(IllegalArgumentException.class, () -> DateValidator.validateDate(nonNumericDate));
    }
}
