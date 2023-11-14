package christmas.util;

import christmas.model.Menu;
import christmas.model.OrderMenu;
import christmas.view.Messages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderParser {

    public static List<OrderMenu> validateOrder(String inputMenus) {
        String[] menuEntries = inputMenus.split(",");
        List<OrderMenu> orderMenus = new ArrayList<>();

        for (String entry : menuEntries) {
            OrderMenu orderMenu = parseOrderEntry(entry.trim());
            orderMenus.add(orderMenu);
        }
        return orderMenus;
    }

    private static OrderMenu parseOrderEntry(String entry) {
        String[] menuAndQuantity = entry.split("-");
        validateMenuQuantityArray(menuAndQuantity);

        String menuName = menuAndQuantity[0].trim();
        int quantity = parseQuantity(menuAndQuantity);
        Menu menu = findMenu(menuName);

        return new OrderMenu(menu, quantity);
    }

    private static int parseQuantity(String[] menuAndQuantity) {
        try {
            return Integer.parseInt(menuAndQuantity[1].trim());
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException(Messages.INVALID_ORDER_ERROR, e);
        }
    }

    private static Menu findMenu(String menuName) {
        return Arrays.stream(Menu.values())
                .filter(m -> m.getName().equals(menuName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(Messages.INVALID_ORDER_ERROR));
    }

    private static void validateMenuQuantityArray(String[] menuQuantityArray) {
        if (menuQuantityArray.length != 2) {
            throw new IllegalArgumentException(Messages.INVALID_ORDER_ERROR);
        }
    }
}
