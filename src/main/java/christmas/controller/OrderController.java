package christmas.controller;

import christmas.config.EventDate;
import christmas.config.TotalOrderAmount;
import christmas.model.EventGift;
import christmas.model.EventGiftEvent;
import christmas.model.OrderMenu;
import christmas.model.WeekEvent;
import christmas.util.DateValidator;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.time.LocalDate;
import java.util.List;

public class OrderController {

    private LocalDate orderDate;
    private String InputOrderDay;

    public void run() {
        printGreeting();
        readDate();
        createOrderLocalDate(parseDate());

    }

    private void printGreeting() {
        OutputView.printGreeting();
    }

    private void readDate() {
        String orderDate = InputView.readDate();
        validateDate(orderDate);
    }

    private void validateDate(String orderDate) {
        if (!DateValidator.validateDate(orderDate)) {
            readDate();
        }
        if (DateValidator.validateDate(orderDate)) {
            this.InputOrderDay = orderDate;
        }
    }

    private int parseDate() {
        return DateValidator.parseDate(this.InputOrderDay);
    }

    private void createOrderLocalDate(int orderDay) {
        this.orderDate = LocalDate.of(
                EventDate.DECEMBER_2023.getEventYear(),
                EventDate.DECEMBER_2023.getEventMonth(),
                orderDay);
    }

    private void readMenu() {
        String menus = InputView.readMenu();
    }

    private void validateMenu() {
        if()
    }

    public int calculateTotalOrderAmount(List<OrderMenu> orderMenus) {
        int totalAmount = 0;

        for (OrderMenu order : orderMenus) {
            totalAmount += order.getMenu().getPrice() * order.getQuantity();
        }

        return totalAmount;
    }

    public List<EventGiftEvent> calculateEventGift(List<OrderMenu> orderMenus) {
        int totalOrderAmount = calculateTotalOrderAmount(orderMenus);

        if (totalOrderAmount >= TotalOrderAmount.EVENT_GIFT_THRESHOLD.getAmount()) {
            return List.of(EventGiftEvent.giftGiven(EventGift.CHAMPAGNE));
        }
        return List.of(EventGiftEvent.noGiftGiven());
    }

    public WeekEvent calculateWeekEvent(Integer eventDay) {
        return WeekEvent.getDayOfWeek(LocalDate.of(
                EventDate.DECEMBER_2023.getEventYear(),
                EventDate.DECEMBER_2023.getEventMonth(),
                eventDay));
    }
}
