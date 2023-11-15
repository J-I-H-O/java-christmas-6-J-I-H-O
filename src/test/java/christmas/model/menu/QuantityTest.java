package christmas.model.menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QuantityTest {
    @Test
    void 숫자가_아닌_값_입력시_예외발생() {
        String input = "a";
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Quantity(input));
    }

    @Test
    void 한개_미만의_값_입력시_예외발생() {
        String input = "0";
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Quantity(input));
    }

    @Test
    void 음수_입력시_예외발생() {
        String input = "-1";
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Quantity(input));
    }
}