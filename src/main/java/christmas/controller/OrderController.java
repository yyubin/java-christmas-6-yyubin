package christmas.controller;

import christmas.config.EventDate;
import christmas.config.TotalOrderAmount;
import christmas.model.*;
import christmas.util.DateValidator;
import christmas.util.MenuValidator;
import christmas.util.OrderParser;
import christmas.view.InputView;
import christmas.view.OutputView;
import org.junit.jupiter.api.Order;

import java.time.LocalDate;
import java.util.List;

public class OrderController {

    private LocalDate orderDate;
    private String InputOrderDay;
    private List<OrderMenu> orderMenus;

    public void run() {
        printGreeting();
        readDate();
        createOrderLocalDate(parseDate());
        readMenu();
        printEventPreviewHeader();
        printOrderMenus();
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
        String inputOrderMenus = InputView.readMenu();
        validateMenu(inputOrderMenus);
    }

    private void validateMenu(String inputMenus) {
        try {
            List<OrderMenu> orderMenus = OrderParser.validateOrder(inputMenus);
            MenuValidator.validateOrder(orderMenus);
            this.orderMenus = orderMenus;
        } catch (IllegalArgumentException e) {
            OutputView.print(e.getMessage());
            readMenu();
        }
    }

    private void printEventPreviewHeader() {
        OutputView.printEventPreviewHeader(orderDate.getMonthValue(), orderDate.getDayOfMonth());
    }

    private void printOrderMenus() {
        OutputView.printMenu(this.orderMenus);
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
