package christmas.view;

import christmas.config.BadgeType;
import christmas.config.EventGift;
import christmas.model.BenefitDetail;

import java.util.List;

public class OutputView {

    public static void printGreeting() {
        System.out.println(Messages.GREETING);
    }

    public static void printAskVisitDate() {
        System.out.println(Messages.ASK_VISIT_DATE);
    }

    public static void printInvalidDateError() {
        System.out.println(Messages.INVALID_DATE_ERROR);
    }

    public static void printAskOrdersMenu() {
        System.out.println(Messages.ASK_MENU_ORDER);
    }

    public static void printInvalidOrderError() {
        System.out.println(Messages.INVALID_ORDER_ERROR);
    }

    public static void printEventPreviewHeader() {
        System.out.println(Messages.EVENT_PREVIEW_HEADER);
    }

    public static void printMenu(List<String> orderedMenu) {
        System.out.println(Messages.MENU_HEADER);
        for (String menu : orderedMenu) {
            System.out.println(menu);
        }
        System.out.println();
    }

    public static void printPaymentAmount(int totalPaymentAmount) {
        System.out.println(Messages.PAYMENT_AMOUNT_HEADER);
        System.out.println(String.format(Messages.PAYMENT_AMOUNT, totalPaymentAmount));
        System.out.println();
    }

    public static void printEventGift(EventGift eventGift) {
        System.out.println(Messages.GIFT_HEADER);
        if (eventGift == null) {
            System.out.println(Messages.NO_GIFT);
            System.out.println();
            return;
        }
        System.out.println(String.format(Messages.GIFT_MENU, eventGift.getGiftName(), eventGift.getGiftCount()));
        System.out.println();
    }

    public static void printBenefitDetails(List<BenefitDetail> benefitDetails) {
        System.out.println(Messages.BENEFIT_HEADER);
        if (benefitDetails.isEmpty()) {
            System.out.println(Messages.NO_BENEFIT);
            System.out.println();
            return;
        }
        for (BenefitDetail benefit : benefitDetails) {
            System.out.println(String.format(Messages.BENEFIT_CONTENT, benefit.getBenefitName(), benefit.getBenefitAmount()));
        }
        System.out.println();
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

}
