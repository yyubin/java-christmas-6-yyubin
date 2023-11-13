package christmas.util;

import christmas.view.Messages;

public class DateValidator {
    public static int validateDate(String orderDate) {
        try {
            int parsedDate = Integer.parseInt(orderDate);
            if (parsedDate < 0) {
                throw new IllegalArgumentException(Messages.INVALID_DATE_ERROR);
            }
            return parseDate(orderDate);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Messages.INVALID_DATE_ERROR);
        }
    }

    private static int parseDate(String orderDate) {
        try {
            return Integer.parseInt(orderDate);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Messages.INVALID_DATE_ERROR);
        }
    }
}
