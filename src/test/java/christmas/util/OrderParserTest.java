package christmas.util;

import christmas.model.Menu;
import christmas.model.OrderMenu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OrderParserTest {
    @DisplayName("유효한 주문, 유효하지 않은 주문 파싱 테스트")
    @Test
    void parseOrder() {
        String validOrderInput = "양송이수프-2,타파스-1,시저샐러드-3";
        String invalidOrderInput = "양송이수프-2,타파스,시저샐러드-3";

        List<OrderMenu> validOrderList = OrderParser.validateOrder(validOrderInput);

        assertAll(
                () -> assertEquals(2, validOrderList.get(0).getQuantity()),
                () -> assertEquals(Menu.MUSHROOM_SOUP, validOrderList.get(0).getMenu()),
                () -> assertEquals(1, validOrderList.get(1).getQuantity()),
                () -> assertEquals(Menu.TAPAS, validOrderList.get(1).getMenu()),
                () -> assertEquals(3, validOrderList.get(2).getQuantity()),
                () -> assertEquals(Menu.CAESAR_SALAD, validOrderList.get(2).getMenu())
        );

        assertThrows(IllegalArgumentException.class, () -> OrderParser.validateOrder(invalidOrderInput));
    }
}
