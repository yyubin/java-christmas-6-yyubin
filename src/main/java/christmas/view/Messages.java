package christmas.view;

import christmas.config.EventDate;

public class Messages {
    public static final String GREETING = "안녕하세요! 우테코 식당 " + EventDate.DECEMBER_2023.getEventMonth() + "월 이벤트 플래너입니다.";
    public static final String ASK_VISIT_DATE = EventDate.DECEMBER_2023.getEventMonth() + "월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    public static final String INVALID_DATE_ERROR = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";

    public static final String ASK_MENU_ORDER = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";
    public static final String INVALID_ORDER_ERROR = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";

    public static final String EVENT_PREVIEW_HEADER = "%d월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    public static final String MENU_HEADER = "<주문 메뉴>";
    public static final String ORDER_MENU = "%s %d개";
    public static final String PAYMENT_AMOUNT_HEADER = "<할인 전 총주문 금액>";

    public static final String PAYMENT_AMOUNT = "%d원";

    public static final String GIFT_HEADER = "<증정 메뉴>";
    public static final String GIFT_MENU = "%s %d개";
    public static final String NO_GIFT = "없음";

    public static final String BENEFIT_HEADER = "<혜택 내역>";
    public static final String BENEFIT_CONTENT = "%s: %d원";
    public static final String NO_BENEFIT = "없음";

    public static final String TOTAL_BENEFIT_AMOUNT = "<총혜택 금액>";

    public static final String EXPECTED_PAYMENT_AMOUNT = "<할인 후 예상 결제 금액>";

    public static final String DECEMBER_EVENT_BADGE = "<" + EventDate.DECEMBER_2023.getEventMonth() + "월 이벤트 배지>";
    public static final String NO_BADGE = "없음";
}
