package christmas.model.discount;

import christmas.model.common.VisitingDate;
import christmas.model.menu.OrderMenus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DiscountGeneratorTest {
    private static final String WEEKDAY_INPUT = "5";
    private static final String WEEKEND_INPUT = "2";
    private static final String SPECIAL_DAY_INPUT = "3";
    private static final String NON_SPECIAL_DAY_INPUT = "7";

    @Test
    void 크리스마스_디데이_할인_기간이_지나면_결과는_null() {
        String dateInput = "30";
        VisitingDate visitingDate = new VisitingDate(dateInput);
        Discount discount = DiscountGenerator.generateDDayDiscount(visitingDate);

        Assertions.assertNull(discount);
    }

    @Test
    void 크리스마스_디데이_할인_금액은_1000원으로_시작하여_100원씩_증가() {
        String dateInput = "20";
        VisitingDate visitingDate = new VisitingDate(dateInput);
        Discount discount = DiscountGenerator.generateDDayDiscount(visitingDate);

        int expected = 1000 + 100 * (visitingDate.getDate() - 1);
        Assertions.assertEquals(expected, discount.getAmount());
    }

    @Test
    void 평일할인_평일이_아니면_결과는_null() {
        String orderMenusInput = "티본스테이크-1,바비큐립-1,초코케이크-1,아이스크림-1";

        VisitingDate visitingDate = new VisitingDate(WEEKEND_INPUT);
        OrderMenus orderMenus = new OrderMenus(orderMenusInput);
        Discount discount = DiscountGenerator.generateWeekdayDiscount(visitingDate, orderMenus);

        Assertions.assertNull(discount);
    }

    @Test
    void 평일할인_할인_금액은_디저트메뉴_1개당_2023원() {
        String orderMenusInput = "티본스테이크-1,바비큐립-1,초코케이크-1,아이스크림-1";

        VisitingDate visitingDate = new VisitingDate(WEEKDAY_INPUT);
        OrderMenus orderMenus = new OrderMenus(orderMenusInput);
        Discount discount = DiscountGenerator.generateWeekdayDiscount(visitingDate, orderMenus);

        int expected = 2 * 2023;
        Assertions.assertEquals(expected, discount.getAmount());
    }

    @Test
    void 주말할인_주말이_아니면_결과는_null() {
        String orderMenusInput = "티본스테이크-1,바비큐립-1,초코케이크-1,아이스크림-1";

        VisitingDate visitingDate = new VisitingDate(WEEKDAY_INPUT);
        OrderMenus orderMenus = new OrderMenus(orderMenusInput);
        Discount discount = DiscountGenerator.generateWeekendDiscount(visitingDate, orderMenus);

        Assertions.assertNull(discount);
    }

    @Test
    void 주말할인_할인_금액은_메인메뉴_1개당_2023원() {
        String orderMenusInput = "티본스테이크-1,바비큐립-1,초코케이크-1,아이스크림-1";

        VisitingDate visitingDate = new VisitingDate(WEEKEND_INPUT);
        OrderMenus orderMenus = new OrderMenus(orderMenusInput);
        Discount discount = DiscountGenerator.generateWeekendDiscount(visitingDate, orderMenus);

        int expected = 2 * 2023;
        Assertions.assertEquals(expected, discount.getAmount());
    }

    @Test
    void 특별할인_특별할인일이_아니면_결과는_null() {
        VisitingDate visitingDate = new VisitingDate(NON_SPECIAL_DAY_INPUT);
        Discount discount = DiscountGenerator.generateSpecialDiscount(visitingDate);

        Assertions.assertNull(discount);
    }

    @Test
    void 특별할인_특별할인일에는_1000원_할인() {
        VisitingDate visitingDate = new VisitingDate(SPECIAL_DAY_INPUT);
        Discount discount = DiscountGenerator.generateSpecialDiscount(visitingDate);

        int expected = 1000;
        Assertions.assertEquals(expected, discount.getAmount());
    }

    @Test
    void 증정이벤트_총주문_금액이_12만원_미만이면_null() {
        String orderMenusInput = "티본스테이크-1";
        OrderMenus orderMenus = new OrderMenus(orderMenusInput);
        Discount discount = DiscountGenerator.generateGiveawayDiscount(orderMenus);

        Assertions.assertNull(discount);
    }

    @Test
    void 증정이벤트_총주문_금액을_만족하면_25000할인으로_표시() {
        String orderMenusInput = "티본스테이크-5";
        OrderMenus orderMenus = new OrderMenus(orderMenusInput);
        Discount discount = DiscountGenerator.generateGiveawayDiscount(orderMenus);

        int expected = 25000;
        Assertions.assertEquals(expected, discount.getAmount());
    }
}