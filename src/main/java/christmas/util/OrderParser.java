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

        if (menuAndQuantity.length != 2) {
            throw new IllegalArgumentException(Messages.INVALID_ORDER_ERROR);
        }

        String menuName = menuAndQuantity[0].trim();
        int quantity = Integer.parseInt(menuAndQuantity[1].trim());

        Menu menu = Arrays.stream(Menu.values())
                .filter(m -> m.getName().equals(menuName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(Messages.INVALID_ORDER_ERROR));

        return new OrderMenu(menu, quantity);
    }
}
