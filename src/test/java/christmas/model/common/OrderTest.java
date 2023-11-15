package christmas.model.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class OrderTest {
    @Test
    void 주문_입력이_null인_경우_예외발생() {
        String orderString = null;
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Order.validateOrder(orderString));
    }

    @Test
    void 주문_입력이_빈_문자열인_경우_예외발생() {
        String orderString = "";
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Order.validateOrder(orderString));
    }

    @Test
    void 주문_형식이_예시와_다른_경우_예외발생() {
        List<String> list = Arrays.asList("a-1,b-1", "가-a", "1-가", "a-1", "가-가",
                "가-1,가", "-,-,-", ",,", "-", " ", "1");

        list.forEach(order -> {
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> Order.validateOrder(order));
        });
    }

    @Test
    void 주문_형식이_일치하는_경우_예외_발생하지_않음() {
        List<String> list = Arrays.asList("가-1", "가-1,나-1,다-1");
        list.forEach((order -> {
            Assertions.assertDoesNotThrow(() -> Order.validateOrder(order));
        }));
    }
}