package christmas.controller;

import christmas.config.EventDate;
import christmas.model.*;
import christmas.util.DateValidator;
import christmas.util.EventHandler;
import christmas.util.MenuValidator;
import christmas.util.OrderParser;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.time.LocalDate;
import java.util.List;

public class OrderController {

    private LocalDate orderDate;
    private String InputOrderDay;
    private List<OrderMenu> orderMenus;
    private int totalOrderAmount;
    private EventGiftResult eventGift;

    private final EventHandler eventHandler;

    public OrderController(EventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    public void run() {
        printGreeting();
        readDate();
        createOrderLocalDate(parseDate());
        readMenu();
        printEventPreviewHeader();
        printOrderMenus();
        printTotalOrderAmount();
        printEventGift();
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

    private void printTotalOrderAmount() {
        this.totalOrderAmount = eventHandler.calculateTotalOrderAmount(this.orderMenus);
        OutputView.printPaymentAmount(this.totalOrderAmount);
    }

    private void printEventGift() {
        this.eventGift = eventHandler.calculateEventGift(this.totalOrderAmount);
        OutputView.printEventGift(this.eventGift);
    }

    private void printBenfits() {
        OutputView.printBenefitDetails();
    }

}
