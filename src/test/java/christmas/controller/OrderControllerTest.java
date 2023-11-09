package christmas.controller;

import christmas.model.EventGift;
import christmas.model.EventGiftResult;
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

    @DisplayName("이벤트 기프트 주어지지 않음")
    @Test
    void calculateEventGift_NoGift() {
        List<OrderMenu> orderMenus = List.of(
                new OrderMenu(Menu.CAESAR_SALAD, 1),
                new OrderMenu(Menu.TAPAS, 1)
        );

        OrderController orderController = new OrderController();

        List<EventGiftResult> eventGiftResults = orderController.calculateEventGift(orderMenus);

        assertEquals(1, eventGiftResults.size());
        EventGiftResult result = eventGiftResults.get(0);
        assertEquals(EventGift.NO_GIFT, result.getEventGift());
    }

    @DisplayName("이벤트 기프트 주어짐")
    @Test
    void calculateEventGift_GiftGiven() {
        List<OrderMenu> orderMenus = List.of(
                new OrderMenu(Menu.TAPAS, 2),
                new OrderMenu(Menu.CHOCOLATE_CAKE, 10)
        );

        OrderController orderController = new OrderController();

        List<EventGiftResult> eventGiftResults = orderController.calculateEventGift(orderMenus);

        assertEquals(1, eventGiftResults.size());
        EventGiftResult result = eventGiftResults.get(0);
        assertEquals(EventGift.CHAMPAGNE, result.getEventGift());
    }
}
