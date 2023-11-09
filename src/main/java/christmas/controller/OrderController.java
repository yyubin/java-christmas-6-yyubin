package christmas.controller;

import christmas.model.OrderMenu;

import java.util.List;

public class OrderController {

    public int calculateTotalOrderAmount(List<OrderMenu> orderList) {
        int totalAmount = 0;

        for (OrderMenu order : orderList) {
            totalAmount += order.getMenu().getPrice() * order.getQuantity();
        }

        return totalAmount;
    }
}
