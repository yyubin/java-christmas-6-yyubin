package christmas.validator;

import christmas.config.TotalOrderAmount;

public class EventValidator {

    public static boolean validateTotalOrderAmount(int totalAmount) {
        return totalAmount >= TotalOrderAmount.EVENT_GIFT_THRESHOLD.getAmount();
    }

}
