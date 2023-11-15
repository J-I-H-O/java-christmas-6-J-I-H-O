package christmas.view;

import christmas.model.discount.AppliedDiscounts;
import christmas.model.menu.OrderMenus;
import christmas.utils.Formatter;

import java.text.DecimalFormat;

public class OutputView {
    private static final String WELCOME_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String EVENT_START_MESSAGE = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String MENU_MESSAGE = "<주문 메뉴>";
    private static final String TOTAL_PRICE_BEFORE_DISCOUNT_MESSAGE = "<할인 전 총주문 금액>";
    private static final String GIVEAWAY_MENU_MESSAGE = "<증정 메뉴>";
    private static final String DISCOUNT_LIST_MESSAGE = "<혜택 내역>";
    private static final String TOTAL_BENEFIT_AMOUNT_MESSAGE = "<총혜택 금액>";
    private static final String TOTAL_PRICE_AFTER_DISCOUNT_MESSAGE = "<할인 후 예상 결제 금액>";

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
        System.out.println(Formatter.formatToCurrencyWon(price));
        System.out.println();
    }

    public static void printGift(AppliedDiscounts appliedDiscounts) {
        System.out.println(GIVEAWAY_MENU_MESSAGE);
        System.out.println(appliedDiscounts.getGiftName());
        System.out.println();
    }

    public static void printDiscounts(AppliedDiscounts appliedDiscounts) {
        System.out.println(DISCOUNT_LIST_MESSAGE);
        System.out.println(appliedDiscounts);
    }

    public static void printTotalBenefitAmount(AppliedDiscounts appliedDiscounts) {
        int amount = -appliedDiscounts.getTotalBenefitAmount();
        System.out.println(TOTAL_BENEFIT_AMOUNT_MESSAGE);
        System.out.println(Formatter.formatToCurrencyWon(amount));
        System.out.println();
    }

    public static void printTotalPrice(OrderMenus orderMenus, AppliedDiscounts appliedDiscounts) {
        int price = orderMenus.getTotalPrice() - appliedDiscounts.getTotalDiscountAmount();
        System.out.println(TOTAL_PRICE_AFTER_DISCOUNT_MESSAGE);
        System.out.println(Formatter.formatToCurrencyWon(price));
        System.out.println();
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
