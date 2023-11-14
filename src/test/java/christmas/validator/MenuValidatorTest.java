package christmas.validator;

import christmas.model.Menu;
import christmas.model.OrderMenu;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MenuValidatorTest {

    @Test
    void validateOrder_유효한_주문리스트_예외_발생하지_않음() {
        Menu menu1 = Menu.TAPAS;
        Menu menu2 = Menu.RED_WINE;
        OrderMenu order1 = new OrderMenu(menu1, 2);
        OrderMenu order2 = new OrderMenu(menu2, 1);

        MenuValidator.validateOrder(Arrays.asList(order1, order2));
    }

    @Test
    void validateOrder_아이템_수가_너무_많음_예외_발생() {
        Menu menu1 = Menu.T_BONE_STEAK;
        Menu menu2 = Menu.ICE_CREAM;
        OrderMenu order1 = new OrderMenu(menu1, 3);
        OrderMenu order2 = new OrderMenu(menu2, 18);

        System.out.println(Arrays.asList(order1, order2).size());

        assertThrows(IllegalArgumentException.class, () ->
                MenuValidator.validateOrder(Arrays.asList(order1, order2))
        );
    }

    @Test
    void validateOrder_음료만_주문_예외_발생() {
        Menu menu = Menu.ZERO_COLA;
        OrderMenu order = new OrderMenu(menu, 5);

        assertThrows(IllegalArgumentException.class, () ->
                MenuValidator.validateOrder(Arrays.asList(order))
        );
    }

    @Test
    void validateOrder_잘못된_음료만_주문_예외_발생() {
        Menu menu1 = Menu.ICE_CREAM;
        Menu menu2 = Menu.RED_WINE;
        OrderMenu order1 = new OrderMenu(menu1, 2);
        OrderMenu order2 = new OrderMenu(menu2, 1);

        MenuValidator.validateOrder(Arrays.asList(order1, order2));
    }
}
