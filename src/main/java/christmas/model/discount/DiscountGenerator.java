package christmas.model.discount;

import christmas.model.common.VisitingDate;
import christmas.model.menu.OrderMenus;

public class DiscountGenerator {
    private static final String D_DAY_EVENT_NAME = "크리스마스 디데이 할인";
    private static final int D_DAY_EVENT_END_DATE = 25;
    private static final int D_DAY_EVENT_START_AMOUNT = 1000;
    private static final int D_DAY_EVENT_CUMULATIVE_AMOUNT = 100;
    private static final String WEEKDAY_EVENT_NAME = "평일 할인";
    private static final String WEEKEND_EVENT_NAME = "주말 할인";
    private static final int WEEKDAY_WEEKEND_DISCOUNT_AMOUNT = 2023;

    public static Discount generateDDayDiscount(int date) {
        if (D_DAY_EVENT_END_DATE < date) {
            return null;
        }
        int discountAmount = D_DAY_EVENT_START_AMOUNT + (date - 1) * D_DAY_EVENT_CUMULATIVE_AMOUNT;
        return new Discount(D_DAY_EVENT_NAME, discountAmount);
    }

    public static Discount generateWeekdayDiscount(VisitingDate visitingDate, OrderMenus orderMenus) {
        int discountAmount = WEEKDAY_WEEKEND_DISCOUNT_AMOUNT * orderMenus.countDessertMenus();
        if (visitingDate.isWeekend() || discountAmount == 0) {
            return null;
        }
        return new Discount(WEEKDAY_EVENT_NAME, discountAmount);
    }

    public static Discount generateWeekendDiscount(VisitingDate visitingDate, OrderMenus orderMenus) {
        int discountAmount = WEEKDAY_WEEKEND_DISCOUNT_AMOUNT * orderMenus.countMainMenus();
        if (!visitingDate.isWeekend() || discountAmount == 0) {
            return null;
        }
        return new Discount(WEEKEND_EVENT_NAME, discountAmount);
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
