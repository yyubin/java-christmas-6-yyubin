package christmas.controller;

import christmas.config.TotalOrderAmount;
import christmas.model.EventGift;
import christmas.model.EventGiftResult;
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

    public List<EventGiftResult> calculateEventGift(List<OrderMenu> orderMenus) {
        int totalOrderAmount = calculateTotalOrderAmount(orderMenus);

        if (totalOrderAmount >= TotalOrderAmount.EVENT_GIFT_THRESHOLD.getAmount()) {
            return List.of(EventGiftResult.giftGiven(EventGift.CHAMPAGNE));
        }
        return List.of(EventGiftResult.noGiftGiven());
    }
}
