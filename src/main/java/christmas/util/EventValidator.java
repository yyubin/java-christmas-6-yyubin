package christmas.util;

import christmas.config.TotalOrderAmount;
import christmas.model.MenuType;
import christmas.model.OrderMenu;
import christmas.view.Messages;

import java.util.List;

public class EventValidator {

    public static boolean validateTotalOrderAmount(int totalAmount) {
        return totalAmount >= TotalOrderAmount.EVENT_GIFT_THRESHOLD.getAmount();
    }


}
