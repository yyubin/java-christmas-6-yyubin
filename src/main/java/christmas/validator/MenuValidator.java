package christmas.validator;

import christmas.model.MenuType;
import christmas.model.OrderMenu;
import christmas.view.Messages;

import java.util.List;

public class MenuValidator {

    public static void validateOrder(List<OrderMenu> orderMenus) {
        validateMaxOrderCount(orderMenus);
        validateNonExclusiveBeverageOrder(orderMenus);
    }

    private static void validateNonExclusiveBeverageOrder(List<OrderMenu> orderMenus) {
        boolean hasNonBeverage = false;

        for (OrderMenu order : orderMenus) {
            if (order.getMenu().getType() != MenuType.BEVERAGE && order.getQuantity() > 0) {
                hasNonBeverage = true;
                break;
            }
        }
        if (!hasNonBeverage) {
            validateFailOnlyBeverageOrder();
        }
    }

    private static void validateFailOnlyBeverageOrder() {
        throw new IllegalArgumentException(Messages.INVALID_ORDER_ERROR);
    }

    public static void validateMaxOrderCount(List<OrderMenu> orderMenus) {
        int orderMenuCnt = 0;
        for (OrderMenu orderMenu: orderMenus) {
            orderMenuCnt += orderMenu.getQuantity();
        }
        if (orderMenuCnt > 20) {
            throw new IllegalArgumentException(Messages.INVALID_ORDER_ERROR);
        }
    }

}
