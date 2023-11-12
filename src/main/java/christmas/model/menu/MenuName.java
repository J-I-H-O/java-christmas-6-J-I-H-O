package christmas.model.menu;

public class MenuName {
    private static final String INVALID_INPUT_ERROR_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";

    private final String name;

    public MenuName(String name) {
        validateNoInput(name);
        validateNotInMenu(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateNoInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR_MESSAGE);
        }
    }

    private void validateNotInMenu(String input) {
        if (!MenuInfo.isContained(input)) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR_MESSAGE);
        }
    }
}
