package christmas.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Order {
    private static final String INVALID_ORDER_FORMAT_ERROR_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
    private static final String EMPTY_INPUT_ERROR_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
    private static final String ORDER_REGEX = "([가-힣]+-[0-9]+)(,[가-힣]+-[0-9]+)*";

    public static void validateOrder(String input) {
        validateNoInput(input);
        validateOrderFormat(input);
    }

    private static void validateNoInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR_MESSAGE);
        }
    }

    private static void validateOrderFormat(String input) {
        Pattern pattern = Pattern.compile(ORDER_REGEX);
        Matcher matcher = pattern.matcher(input);
        boolean isValid = matcher.matches();
        if (!isValid) {
            throw new IllegalArgumentException(INVALID_ORDER_FORMAT_ERROR_MESSAGE);
        }
    }
}
