package christmas.util;

import christmas.config.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class OrderParserTest {
    @DisplayName("유효한 주문, 유효하지 않은 주문 파싱 테스트")
    @Test
    void parseOrder() {
        String validOrderInput = "양송이수프-2,타파스-1,시저샐러드-3";
        String invalidOrderInput = "양송이수프-2,타파스,시저샐러드-3";

        Map<Menu, Integer> validOrderMap = OrderParser.parseOrder(validOrderInput);

        assertAll(
                () -> assertEquals(2, validOrderMap.get(Menu.MUSHROOM_SOUP)),
                () -> assertEquals(1, validOrderMap.get(Menu.TAPAS)),
                () -> assertEquals(3, validOrderMap.get(Menu.CAESAR_SALAD))
        );

        assertThrows(IllegalArgumentException.class, () -> OrderParser.parseOrder(invalidOrderInput));
    }
}
