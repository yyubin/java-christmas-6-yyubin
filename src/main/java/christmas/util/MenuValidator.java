package christmas.util;

import christmas.config.Menu;
import christmas.view.Messages;

import java.util.List;

public class MenuValidator {
    public static void validateOrderEntry(List<String> menuAndQuantity) {
        validateListSize(menuAndQuantity);
        Menu menu = parseMenu(menuAndQuantity.get(0));
        int quantity = parseQuantity(menuAndQuantity.get(1));
        validatePositiveQuantity(quantity);
    }

    private static void validateListSize(List<String> menuAndQuantity) {
        if (menuAndQuantity.size() != 2) {
            throw new IllegalArgumentException(Messages.INVALID_ORDER_ERROR);
        }
    }

    private static Menu parseMenu(String menuString) {
        return Menu.parse(menuString);
    }

    private static int parseQuantity(String quantityString) {
        try {
            int quantity = Integer.parseInt(quantityString);
            if (quantity <= 0) {
                throw new IllegalArgumentException(Messages.INVALID_ORDER_ERROR);
            }
            return quantity;
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
