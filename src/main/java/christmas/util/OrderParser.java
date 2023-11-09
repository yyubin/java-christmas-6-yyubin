package christmas.util;

import christmas.config.Menu;
import christmas.view.Messages;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderParser {
    public static Map<Menu, Integer> parseOrder(String orderInput) {
        List<String> orders = Arrays.asList(orderInput.split(","));
        return orders.stream()
                .map(OrderParser::parseOrderEntry)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private static Map.Entry<Menu, Integer> parseOrderEntry(String order) {
        String[] menuAndQuantity = order.split("-");
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

        return Map.entry(menu, quantity);
    }
}
