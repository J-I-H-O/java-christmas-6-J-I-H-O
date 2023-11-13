package christmas.model.menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderMenus {
    private static final String INVALID_MENU_ERROR_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
    private static final String MAX_MENU_SIZE_ERROR_MESSAGE = "[ERROR] 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.";
    private static final String NO_SINGLE_ORDER_TYPE = "drink";
    private static final int MAX_MENU_SIZE = 20;

    private List<OrderMenu> orderMenus = null;
    private int totalMenuSize = 0;

    public OrderMenus(String menuInput) {
        orderMenus = new ArrayList<>();
        List<String> menuStrings = splitMenuInput(menuInput);
        menuStrings.forEach(menuString -> {
            OrderMenu orderMenu = new OrderMenu(menuString);

            String menuName = parseMenuName(menuString);
            int menuSize = parseMenuSize(menuString);
            validateDuplicateMenu(menuName);
            validateTotalMenuSize(menuSize);

            addMenu(orderMenu);
        });
        validateDrinkOnly();
    }

    private List<String> splitMenuInput(String menuInput) {
        String[] split = menuInput.split(",");
        return Arrays.asList(split);
    }

    private String parseMenuName(String menuString) {
        String[] split = menuString.split("-");
        return split[0];
    }

    private int parseMenuSize(String menuString) {
        String[] split = menuString.split("-");
        return Integer.parseInt(split[1]);
    }

    private void validateDuplicateMenu(String menuName) {
        boolean isDuplicate = orderMenus.stream()
                .anyMatch(orderMenu -> orderMenu.getOrderMenuName().equals(menuName));

        if (isDuplicate) {
            throw new IllegalArgumentException(INVALID_MENU_ERROR_MESSAGE);
        }
    }

    private void validateTotalMenuSize(int nextMenuSize) {
        if (MAX_MENU_SIZE < totalMenuSize + nextMenuSize) {
            throw new IllegalArgumentException(MAX_MENU_SIZE_ERROR_MESSAGE);
        }
    }

    private void validateDrinkOnly() {
        boolean isInValid = orderMenus.stream()
                .allMatch(orderMenu -> orderMenu.getOrderMenuType().equals(NO_SINGLE_ORDER_TYPE));

        if (isInValid) {
            throw new IllegalArgumentException(INVALID_MENU_ERROR_MESSAGE);
        }
    }

    private void addMenu(OrderMenu orderMenu) {
        totalMenuSize += orderMenu.getOrderQuantity();
        orderMenus.add(orderMenu);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        orderMenus.forEach(orderMenu -> stringBuilder.append(orderMenu).append("\n"));
        return stringBuilder.toString();
    }
}
