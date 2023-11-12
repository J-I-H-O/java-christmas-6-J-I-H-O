package christmas.model.menu;

public class Quantity {
    private static final String INVALID_INPUT_ERROR_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
    private static final int MIN_QUANTITY = 1;

    private final int quantity;

    public Quantity(String quantityInput) {
        validateNumeric(quantityInput);
        int quantity = Integer.parseInt(quantityInput);
        validateQuantityRange(quantity);

        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    private void validateNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR_MESSAGE);
        }
    }

    private void validateQuantityRange(int quantity) {
        if (quantity < MIN_QUANTITY) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR_MESSAGE);
        }
    }
}
