package christmas.model.menu;

public class OrderMenu {
    private static final String INVALID_INPUT_ERROR_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";

    private final MenuInfo menuInfo;
    private final Quantity quantity;
    private final int orderPrice;

    public OrderMenu(String menuString) {
        String[] split = menuString.split("-");
        String menuName = split[0];
        String quantity = split[1];

        validateNoInput(menuName);
        validateNoInput(quantity);

        this.menuInfo = MenuInfo.findMenuInfoByName(menuName);
        this.quantity = new Quantity(quantity);
        this.orderPrice = this.menuInfo.getPrice() * this.quantity.getQuantity();
    }

    private void validateNoInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR_MESSAGE);
        }
    }

    public String getOrderMenuName() {
        return menuInfo.getName();
    }

    public String getOrderMenuType() {
        return menuInfo.getType();
    }

    public int getOrderQuantity() {
        return quantity.getQuantity();
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(menuInfo.getName())
                .append(" ")
                .append(quantity.getQuantity())
                .append("개");
        return stringBuilder.toString();
    }
}
