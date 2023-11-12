package christmas.model;

public class Menu {
    private final OrderMenuName orderMenuName;
    private final OrderQuantity orderQuantity;

    public Menu(OrderMenuName orderMenuName, OrderQuantity orderQuantity) {
        this.orderMenuName = orderMenuName;
        this.orderQuantity = orderQuantity;
    }
}
