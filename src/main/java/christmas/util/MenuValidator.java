package christmas.util;

import christmas.config.Menu;
import christmas.view.Messages;

public class MenuValidator {
    public static void validateOrderEntry(String[] menuAndQuantity) {
        if (menuAndQuantity.length != 2) {
            throw new IllegalArgumentException(Messages.INVALID_ORDER_ERROR);
        }

        Menu menu = Menu.parse(menuAndQuantity[0]);
        int quantity;
        try {
            quantity = Integer.parseInt(menuAndQuantity[1]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Messages.INVALID_ORDER_ERROR);
        }

        if (quantity <= 0) {
            throw new IllegalArgumentException(Messages.INVALID_ORDER_ERROR);
        }
    }
}
