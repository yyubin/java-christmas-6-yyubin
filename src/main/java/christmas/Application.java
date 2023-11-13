package christmas;

import christmas.controller.OrderController;
import christmas.util.EventHandler;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        EventHandler eventHandler = new EventHandler();
        OrderController orderController = new OrderController(eventHandler);
        orderController.run();
    }
}
