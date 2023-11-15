package christmas.controller;

import christmas.model.common.Order;
import christmas.model.common.VisitingDate;
import christmas.model.discount.AppliedDiscounts;
import christmas.model.menu.OrderMenus;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventController {
    public void run() {
        OutputView.printWelcomeMessage();

        VisitingDate visitingDate = getVisitingDate();
        OrderMenus orderMenus = getOrderMenus();
        AppliedDiscounts appliedDiscounts = new AppliedDiscounts(visitingDate, orderMenus);

        printResult(visitingDate, orderMenus, appliedDiscounts);
    }

    private VisitingDate getVisitingDate() {
        try {
            String dateInput = InputView.readDate();
            return new VisitingDate(dateInput);
        } catch(IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getVisitingDate();
        }
    }

    private OrderMenus getOrderMenus() {
        try {
            String orderInput = InputView.readOrder();
            Order.validateOrder(orderInput);
            return new OrderMenus(orderInput);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getOrderMenus();
        }
    }

    private void printResult(VisitingDate visitingDate, OrderMenus orderMenus, AppliedDiscounts appliedDiscounts) {
        OutputView.printEventStartMessage(visitingDate.getDate());
        OutputView.printMenus(orderMenus.toString());
        OutputView.printTotalPriceBeforeDiscount(orderMenus.getTotalPrice());
        OutputView.printGift(appliedDiscounts);
        OutputView.printDiscounts(appliedDiscounts);
        OutputView.printTotalBenefitAmount(appliedDiscounts);
        OutputView.printTotalPrice(orderMenus, appliedDiscounts);
        OutputView.printEventBadge(appliedDiscounts);
    }
}
