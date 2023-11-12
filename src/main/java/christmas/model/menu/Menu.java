package christmas.model.menu;

public class Menu {
    private final MenuName menuName;
    private final Quantity quantity;

    public Menu(String menuString) {
        String[] split = menuString.split("-");
        this.menuName = new MenuName(split[0]);
        this.quantity = new Quantity(split[1]);
    }

    public String getOrderMenuName() {
        return menuName.getName();
    }

    public int getOrderQuantity() {
        return quantity.getQuantity();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(menuName.getName())
                .append(" ")
                .append(quantity.getQuantity())
                .append("개");
        return stringBuilder.toString();
    }
}
