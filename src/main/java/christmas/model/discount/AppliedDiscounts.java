package christmas.model.discount;

import christmas.model.common.VisitingDate;
import christmas.model.menu.OrderMenus;

import java.util.ArrayList;
import java.util.List;

public class AppliedDiscounts {
    private static final String GIVEAWAY_EVENT_NAME = "증정 이벤트";
    private static final int GIVEAWAY_DISCOUNT_AMOUNT = 25000;
    private static final String NOTHING = "없음";
    private static final String GIFT_NAME = "샴페인 1개";

    private final List<Discount> discounts = new ArrayList<>();
    private int totalBenefitAmount = 0;
    private String giftName = NOTHING;

    public AppliedDiscounts(VisitingDate date, OrderMenus menus) {
        if (menus.isDiscountable()) {
            addDiscount(DiscountGenerator.generateDDayDiscount(date));
            addDiscount(DiscountGenerator.generateWeekdayDiscount(date, menus));
            addDiscount(DiscountGenerator.generateWeekendDiscount(date, menus));
            addDiscount(DiscountGenerator.generateSpecialDiscount(date));
            addDiscount(DiscountGenerator.generateGiveawayDiscount(menus));
        }
    }

    private void addDiscount(Discount discount) {
        if (discount == null) {
            return;
        }
        if (discount.getName().equals(GIVEAWAY_EVENT_NAME)) {
            giftName = GIFT_NAME;
        }
        totalBenefitAmount += discount.getAmount();
        discounts.add(discount);
    }

    public boolean isGiftExists() {
        return !giftName.equals(NOTHING);
    }

    public int getTotalBenefitAmount() {
        return totalBenefitAmount;
    }

    public int getTotalDiscountAmount() {
        if (isGiftExists()) {
            return totalBenefitAmount - GIVEAWAY_DISCOUNT_AMOUNT;
        }
        return totalBenefitAmount;
    }

    public String getGiftName() {
        return giftName;
    }

    @Override
    public String toString() {
        if (discounts.isEmpty()) {
            return NOTHING;
        }

        StringBuilder stringBuilder = new StringBuilder();
        discounts.forEach(discount -> {
            stringBuilder
                    .append(discount)
                    .append("\n");
        });
        return stringBuilder.toString();
    }
}
