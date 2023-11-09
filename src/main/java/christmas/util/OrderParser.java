package christmas.util;

import christmas.model.Menu;
import christmas.model.OrderMenu;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OrderParser {
    public static List<OrderMenu> parseOrder(String orderInput) {
        List<String> orders = Arrays.asList(orderInput.split(","));

        return orders.stream()
                .map(OrderParser::parseOrderEntry)
                .collect(Collectors.toList());
    }

    private static OrderMenu parseOrderEntry(String order) {
        List<String> menuAndQuantity = Arrays.asList(order.split("-"));
        MenuValidator.validateOrderEntry(menuAndQuantity);

        Menu menu = MenuValidator.menuParse(menuAndQuantity.get(0));
        int quantity = Integer.parseInt(menuAndQuantity.get(1));

        return new OrderMenu(menu, quantity);
    }
}
