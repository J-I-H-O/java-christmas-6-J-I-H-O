package christmas.model.discount;

import christmas.model.common.VisitingDate;
import christmas.model.menu.OrderMenus;

import java.util.ArrayList;
import java.util.List;

public class AppliedDiscounts {
    private static final String GIVEAWAY_EVENT_NAME = "증정 이벤트";
    private static final int GIVEAWAY_DISCOUNT_AMOUNT = 25000;

    private final List<Discount> discounts = new ArrayList<>();
    private int totalBenefitAmount = 0;
    private boolean isGiftExists = false;

    public AppliedDiscounts(VisitingDate date, OrderMenus menus) {
        addDiscount(DiscountGenerator.generateDDayDiscount(date));
        addDiscount(DiscountGenerator.generateWeekdayDiscount(date, menus));
        addDiscount(DiscountGenerator.generateWeekendDiscount(date, menus));
        addDiscount(DiscountGenerator.generateSpecialDiscount(date));
        addDiscount(DiscountGenerator.generateGiveawayDiscount(menus));
    }

    public int getTotalBenefitAmount() {
        return totalBenefitAmount;
    }

    public int getTotalDiscountAmount() {
        if (isGiftExists) {
            return totalBenefitAmount - GIVEAWAY_DISCOUNT_AMOUNT;
        }
        return totalBenefitAmount;
    }

    private void addDiscount(Discount discount) {
        if (discount == null) {
            return;
        }
        if (discount.getName().equals(GIVEAWAY_EVENT_NAME)) {
            isGiftExists = true;
        }
        totalBenefitAmount += discount.getAmount();
        discounts.add(discount);
    }
}
