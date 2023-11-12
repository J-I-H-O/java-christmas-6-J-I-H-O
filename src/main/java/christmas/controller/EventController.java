package christmas.controller;

import christmas.model.Order;
import christmas.model.VisitingDate;
import christmas.model.menu.OrderMenus;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventController {

    public void run() {
        OutputView.printWelcomeMessage();

        VisitingDate visitingDate = getVisitingDate();
        OrderMenus orderMenus = getOrderMenus();

        OutputView.printMenus(orderMenus);
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
}
