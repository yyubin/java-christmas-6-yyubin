package christmas.util;

import christmas.view.Messages;
import christmas.view.OutputView;

public class DateValidator {
    public static boolean validateDate(String orderDate) {
        try {
            int parsedDate = Integer.parseInt(orderDate);
            if (parsedDate < 0) {
                OutputView.print(Messages.INVALID_DATE_ERROR);
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            OutputView.print(Messages.INVALID_DATE_ERROR);
            return false;
        }
    }

    public static int parseDate(String orderDate) {
        return Integer.parseInt(orderDate);

    }
}
