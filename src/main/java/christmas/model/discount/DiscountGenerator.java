package christmas.model.discount;

import christmas.model.menu.OrderMenus;

public class DiscountGenerator {
    private static final int D_DAY_EVENT_END_DATE = 25;
    private static final int D_DAY_EVENT_START_AMOUNT = 1000;
    private static final int D_DAY_EVENT_CUMULATIVE_AMOUNT = 100;
    private static final String D_DAY_EVENT_NAME = "크리스마스 디데이 할인";

    public static Discount generateDDayDiscount(int date) {
        if (D_DAY_EVENT_END_DATE < date) {
            return null;
        }
        int discountAmount = D_DAY_EVENT_START_AMOUNT + (date - 1) * D_DAY_EVENT_CUMULATIVE_AMOUNT;
        return new Discount(D_DAY_EVENT_NAME, discountAmount);
    }

    public static Discount generateWeekdayDiscount(int date, OrderMenus orderMenus) {
        // TODO: 구현
        return null;
    }

    public static Discount generateWeekendDiscount(int date, OrderMenus orderMenus) {
        // TODO: 구현
        return null;
    }

    public static Discount generateSpecialDiscount(OrderMenus orderMenus) {
        // TODO: 구현
        return null;
    }

    public static Discount generateGiveawayDiscount(OrderMenus orderMenus) {
        // TODO: 구현
        return null;
    }
}
