package christmas.view;

import christmas.config.BadgeType;
import christmas.config.EventType;
import christmas.model.EventGift;
import christmas.model.BenefitDetail;
import christmas.model.EventGiftResult;
import christmas.model.OrderMenu;

import java.util.List;

public class OutputView {

    public static void printGreeting() {
        System.out.println(Messages.GREETING);
    }

    public static void printAskVisitDate() {
        System.out.println(Messages.ASK_VISIT_DATE);
    }
    public static void printAskOrdersMenu() {
        System.out.println(Messages.ASK_MENU_ORDER);
    }

    public static void printEventPreviewHeader(int eventMonth, int eventDay) {
        System.out.println(String.format(Messages.EVENT_PREVIEW_HEADER, eventMonth, eventDay));
        System.out.println();
    }

    public static void printMenu(List<OrderMenu> orderedMenu) {
        System.out.println(Messages.MENU_HEADER);
        for (OrderMenu menu : orderedMenu) {
            System.out.println(String.format(Messages.ORDER_MENU, menu.getMenu().getName(), menu.getQuantity()));
        }
        System.out.println();
    }

    public static void printPaymentAmount(int totalPaymentAmount) {
        System.out.println(Messages.PAYMENT_AMOUNT_HEADER);
        System.out.println(String.format(Messages.PAYMENT_AMOUNT, totalPaymentAmount));
        System.out.println();
    }

    public static void printEventGift(EventGiftResult eventGift) {
        System.out.println(Messages.GIFT_HEADER);
        if (eventGift.getEventGift() == EventGift.NO_GIFT) {
            System.out.println(Messages.NO_GIFT);
            System.out.println();
            return;
        }
        System.out.println(String.format(Messages.GIFT_MENU, eventGift.getEventGift().getGiftName(), eventGift.getEventGift().getGiftCount()));
        System.out.println();
    }

    public static void printBenefitDetails(List<BenefitDetail> benefitDetails) {
        System.out.println(Messages.BENEFIT_HEADER);

        for (BenefitDetail benefit : benefitDetails) {
            if (benefit.getEventType() != EventType.NONE && benefit.getBenefitAmount() > 0) {
                System.out.println(String.format(Messages.BENEFIT_CONTENT, benefit.getEventType().getEventName(), benefit.getBenefitAmount()));
            }
        }
        printBenefitDetailsNone(benefitDetails);
        System.out.println();
    }

    private static void printBenefitDetailsNone(List<BenefitDetail> benefitDetails) {
        if (benefitDetails.isEmpty()) {
            System.out.println(Messages.NO_BENEFIT);
        }
    }

    public static void printTotalBenefitAmount(int totalBenefitAmount) {
        System.out.println(Messages.TOTAL_BENEFIT_AMOUNT);
        System.out.println(String.format(Messages.PAYMENT_AMOUNT, totalBenefitAmount));
        System.out.println();
    }

    public static void printExpectedPaymentAmount(int expectedPaymentAmount) {
        System.out.println(Messages.EXPECTED_PAYMENT_AMOUNT);
        System.out.println(String.format(Messages.PAYMENT_AMOUNT, expectedPaymentAmount));
        System.out.println();
    }

    public static void printEventBadge(BadgeType badgeType) {
        System.out.println(Messages.DECEMBER_EVENT_BADGE);
        if (badgeType == null) {
            System.out.println(Messages.NO_BADGE);
            System.out.println();
            return;
        }
        System.out.println(badgeType.getBadgeName());
        System.out.println();
    }

    public static void print(String message) {
        System.out.println(message);
    }

}
