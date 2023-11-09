package christmas.controller;

import christmas.model.Menu;
import christmas.model.OrderMenu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderControllerTest {

    @DisplayName("할인 전 총 주문 금액 메소드 테스트")
    @Test
    void calculateTotalOrderAmount() {
        OrderController orderController = new OrderController();

        List<OrderMenu> orderList = new ArrayList<>();
        orderList.add(new OrderMenu(Menu.MUSHROOM_SOUP, 2));
        orderList.add(new OrderMenu(Menu.TAPAS, 1));
        orderList.add(new OrderMenu(Menu.CAESAR_SALAD, 3));

        int totalAmount = orderController.calculateTotalOrderAmount(orderList);

        // Assuming prices for Menu items are set accordingly in your Menu enum
        int expectedTotalAmount = (Menu.MUSHROOM_SOUP.getPrice() * 2)
                + (Menu.TAPAS.getPrice() * 1)
                + (Menu.CAESAR_SALAD.getPrice() * 3);

        assertEquals(expectedTotalAmount, totalAmount);
    }
}
