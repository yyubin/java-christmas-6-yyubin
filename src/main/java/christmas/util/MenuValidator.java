package christmas.util;

import christmas.config.Menu;
import christmas.view.Messages;

public class MenuValidator {
    public static void validateOrderEntry(String[] menuAndQuantity) {
        validateArrayLength(menuAndQuantity);
        Menu menu = parseMenu(menuAndQuantity[0]);
        int quantity = parseQuantity(menuAndQuantity[1]);
        validatePositiveQuantity(quantity);
    }

    private static void validateArrayLength(String[] menuAndQuantity) {
        if (menuAndQuantity.length != 2) {
            throw new IllegalArgumentException(Messages.INVALID_ORDER_ERROR);
        }
    }

    private static Menu parseMenu(String menuString) {
        try {
            return Menu.parse(menuString);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(Messages.INVALID_ORDER_ERROR);
        }
    }

    private static int parseQuantity(String quantityString) {
        try {
            return Integer.parseInt(quantityString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Messages.INVALID_ORDER_ERROR);
        }
    }

    private static void validatePositiveQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException(Messages.INVALID_ORDER_ERROR);
        }
    }
}
