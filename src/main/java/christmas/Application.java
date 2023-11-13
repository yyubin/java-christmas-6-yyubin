package christmas;

import christmas.controller.OrderController;
import christmas.service.EventService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        EventService eventService = new EventService();
        OrderController orderController = new OrderController(eventService);
        orderController.run();
    }
}
