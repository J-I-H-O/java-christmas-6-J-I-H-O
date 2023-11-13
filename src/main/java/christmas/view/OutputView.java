package christmas.view;

import christmas.model.menu.OrderMenus;

import java.text.DecimalFormat;

public class OutputView {
    private static final String WELCOME_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String EVENT_START_MESSAGE = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String MENU_MESSAGE = "<주문 메뉴>";
    private static final String TOTAL_PRICE_BEFORE_DISCOUNT_MESSAGE = "<할인 전 총주문 금액>";
    private static final String PRICE_FORMAT = "#,###원";

    public static void printWelcomeMessage() {
        System.out.println(WELCOME_MESSAGE);
    }

    public static void printEventStartMessage(int date) {
        System.out.printf((EVENT_START_MESSAGE) + "%n", date);
        System.out.println();
    }

    public static void printMenus(String orderMenus) {
        System.out.println(MENU_MESSAGE);
        System.out.println(orderMenus);
    }

    public static void printTotalPriceBeforeDiscount(int price) {
        System.out.println(TOTAL_PRICE_BEFORE_DISCOUNT_MESSAGE);
        DecimalFormat format = new DecimalFormat(PRICE_FORMAT);
        System.out.println(format.format(price));
        System.out.println();
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
