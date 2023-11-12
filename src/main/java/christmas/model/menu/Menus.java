package christmas.model.menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Menus {
    private static final String DUPLICATE_MENU_ERROR_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
    private static final String MAX_MENU_SIZE_ERROR_MESSAGE = "[ERROR] 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.";
    private static final String NOT_NUMERIC_ERROR_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
    private static final int MAX_MENU_SIZE = 20;

    private List<Menu> menus = null;    // null을 허용한 대신 public 메서드를 제공하지 않아 NPE 방지
    private int totalMenuSize = 0;

    public Menus(String menuInput) {
        menus = new ArrayList<>();  // IllegalArgumentException 발생 시 이전까지 넣은 Menu들을 모두 초기화 하기 위함
        List<String> menuStrings = splitMenuInput(menuInput);
        menuStrings.forEach(menuString -> {
            Menu menu = new Menu(menuString);

            String menuName = parseMenuName(menuString);
            int menuSize = parseMenuSize(menuString);
            validateDuplicateMenu(menuName);
            validateTotalMenuSize(menuSize);

            addMenu(menu);
        });
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
        boolean isDuplicate = menus.stream()
                .anyMatch(menu -> menu.getOrderMenuName().equals(menuName));

        if (isDuplicate) {
            throw new IllegalArgumentException(DUPLICATE_MENU_ERROR_MESSAGE);
        }
    }

    private void validateTotalMenuSize(int nextMenuSize) {
        if (MAX_MENU_SIZE < totalMenuSize + nextMenuSize) {
            throw new IllegalArgumentException(MAX_MENU_SIZE_ERROR_MESSAGE);
        }
    }

    private void addMenu(Menu menu) {
        totalMenuSize += menu.getOrderQuantity();
        menus.add(menu);
    }
}
