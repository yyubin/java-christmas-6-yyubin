package christmas.validator;

import christmas.view.Messages;

public class DateValidator {
    public static int validateDate(String orderDate) {
        try {
            int parsedDate = Integer.parseInt(orderDate);
            if (parsedDate <= 0 || parsedDate > 31) {
                throw new IllegalArgumentException(Messages.INVALID_DATE_ERROR);
            }
            return parsedDate;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Messages.INVALID_DATE_ERROR);
        }
    }
}
