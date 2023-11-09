package christmas.util;

import christmas.config.Menu;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class OrderParserTest {
    @Test
    void parseOrder() {
        // given
        String validOrderInput = "양송이수프-2,타파스-1,시저샐러드-3";
        String invalidOrderInput = "양송이수프-2,타파스,시저샐러드-3";

        // when
        Map<Menu, Integer> validOrderMap = OrderParser.parseOrder(validOrderInput);

        // then
        assertAll(
                () -> assertEquals(2, validOrderMap.get(Menu.양송이수프)),
                () -> assertEquals(1, validOrderMap.get(Menu.타파스)),
                () -> assertEquals(3, validOrderMap.get(Menu.시저샐러드))
        );

        // when & then
        assertThrows(IllegalArgumentException.class, () -> OrderParser.parseOrder(invalidOrderInput));
    }
}
