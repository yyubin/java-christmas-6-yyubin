package christmas;

import christmas.controller.OrderController;
import christmas.service.EventService;
import christmas.validator.EventValidator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        EventValidator eventValidator = new EventValidator();
        EventService eventService = new EventService(eventValidator);
        OrderController orderController = new OrderController(eventService);
        orderController.run();
    }
}
