package christmas.model.discount;

import christmas.model.common.VisitingDate;
import christmas.model.menu.OrderMenus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AppliedDiscountsTest {
    @Test
    void 총주문_금액이_10000원_미만이면_이벤트_참여불가() {
        String dateInput = "5";
        String orderMenusInput = "아이스크림-1";

        VisitingDate visitingDate = new VisitingDate(dateInput);
        OrderMenus orderMenus = new OrderMenus(orderMenusInput);
        AppliedDiscounts appliedDiscounts = new AppliedDiscounts(visitingDate, orderMenus);

        int expected = 0;
        int benefitAmount = appliedDiscounts.calculateTotalBenefitAmount();
        Assertions.assertEquals(expected, benefitAmount);
    }
}