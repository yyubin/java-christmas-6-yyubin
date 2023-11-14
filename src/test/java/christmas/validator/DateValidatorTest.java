package christmas.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DateValidatorTest {
    @Test
    public void 테스트_유효한_날짜() {
        // Arrange
        String 유효한날짜 = "15";

        // Act
        int 결과 = DateValidator.validateDate(유효한날짜);

        // Assert
        assertEquals(15, 결과);
    }

    @Test
    public void 테스트_유효하지_않은_음수_날짜() {
        // Arrange
        String 유효하지않은날짜 = "-5";

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> DateValidator.validateDate(유효하지않은날짜));
    }

    @Test
    public void 테스트_유효하지_않은_제로_날짜() {
        // Arrange
        String 유효하지않은날짜 = "0";

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> DateValidator.validateDate(유효하지않은날짜));
    }

    @Test
    public void 테스트_유효하지_않은_큰_날짜() {
        // Arrange
        String 유효하지않은날짜 = "40";

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> DateValidator.validateDate(유효하지않은날짜));
    }

    @Test
    public void 테스트_숫자가_아닌_유효하지_않은_날짜() {
        // Arrange
        String 유효하지않은날짜 = "abc";

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> DateValidator.validateDate(유효하지않은날짜));
    }
}
