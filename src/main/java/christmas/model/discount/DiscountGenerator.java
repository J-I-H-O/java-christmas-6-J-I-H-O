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

    private static final String SPECIAL_EVENT_NAME = "특별 할인";
    private static final int SPECIAL_DISCOUNT_AMOUNT = 1000;

    private static final String GIVEAWAY_EVENT_NAME = "증정 이벤트";
    private static final int GIVEAWAY_MIN_CRITERIA = 120000;
    private static final int GIVEAWAY_DISCOUNT_AMOUNT = 25000;

    private DiscountGenerator() {
    }

    public static Discount generateDDayDiscount(VisitingDate visitingDate) {
        int date = visitingDate.getDate();
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

    public static Discount generateSpecialDiscount(VisitingDate visitingDate) {
        if (!visitingDate.isSpecialDay()) {
            return null;
        }
        return new Discount(SPECIAL_EVENT_NAME, SPECIAL_DISCOUNT_AMOUNT);
    }

    public static Discount generateGiveawayDiscount(OrderMenus orderMenus) {
        if (orderMenus.getTotalPrice() < GIVEAWAY_MIN_CRITERIA) {
            return null;
        }
        return new Discount(GIVEAWAY_EVENT_NAME, GIVEAWAY_DISCOUNT_AMOUNT);
    }
}
