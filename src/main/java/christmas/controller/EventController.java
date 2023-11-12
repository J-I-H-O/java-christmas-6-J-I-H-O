package christmas.controller;

import christmas.model.VisitingDate;
import christmas.model.menu.Menus;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventController {

    public void run() {
        OutputView.printWelcomeMessage();

        VisitingDate visitingDate = getVisitingDate();
        Menus menus = getMenus();

        OutputView.printMenus(menus);
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

    private Menus getMenus() {
        try {
            String menuInput = InputView.readMenu();
            return new Menus(menuInput);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getMenus();
        }
    }
}
