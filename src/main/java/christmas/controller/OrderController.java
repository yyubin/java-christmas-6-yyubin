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
    private int inputOrderDay;
    private List<OrderMenu> orderMenus;
    private int totalOrderAmount;
    private List<BenefitDetail> benefitDetails;
    private int totalBenefitsAmount;

    private final EventHandler eventHandler;

    public OrderController(EventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    public void run() {
        printGreeting();
        readDate();
        createOrderLocalDate(this.inputOrderDay);
        readMenu();
        printEventPreviewHeader();
        printOrderMenus();
        printTotalOrderAmount();
        printEventGift();
        printBenfits();
        printTotalBenefitsAmount();
        printEventBadge();
    }

    private void printGreeting() {
        OutputView.printGreeting();
    }

    private void readDate() {
        String orderDate = InputView.readDate();
        validateDate(orderDate);
    }

    private void validateDate(String orderDate) {
        try {
            this.inputOrderDay = DateValidator.validateDate(orderDate);

        } catch (IllegalArgumentException e) {
            OutputView.print(e.getMessage());
            readDate();
        }
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
        EventGiftResult eventGift = eventHandler.calculateEventGift(this.totalOrderAmount);
        OutputView.printEventGift(eventGift);
    }

    private void printBenfits() {
        this.benefitDetails = eventHandler.calculateBenefits(orderDate, orderMenus, totalOrderAmount);
        OutputView.printBenefitDetails(this.benefitDetails);
    }

    private void printTotalBenefitsAmount() {
        this.totalBenefitsAmount = eventHandler.calculateTotalBenefitsAmount(this.benefitDetails);
        OutputView.printTotalBenefitAmount(this.totalBenefitsAmount);
    }

    private void printEventBadge() {
        OutputView.printEventBadge(eventHandler.calculateEventBadge(this.totalBenefitsAmount));
    }

}
