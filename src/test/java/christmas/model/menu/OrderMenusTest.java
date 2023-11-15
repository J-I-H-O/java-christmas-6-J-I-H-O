package christmas.model.menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderMenusTest {
    @Test
    void 중복된_메뉴_입력시_예외발생() {
        String input = "초코케이크-1,초코케이크-5";
        Assertions.assertThrows(IllegalArgumentException.class, () -> new OrderMenus(input));
    }

    @Test
    void 전체_메뉴의_개수가_20개를_초과하면_예외발생() {
        String input = "초코케이크-5,타파스-5,제로콜라-15";
        Assertions.assertThrows(IllegalArgumentException.class, () -> new OrderMenus(input));
    }

    @Test
    void 음료만_주문하는_경우_예외발생() {
        String input = "제로콜라-5,레드와인-5";
        Assertions.assertThrows(IllegalArgumentException.class, () -> new OrderMenus(input));
    }

    @Test
    void 전체_메뉴중_디저트_개수세기() {
        String input = "제로콜라-5,레드와인-5,초코케이크-3,아이스크림-3";
        OrderMenus orderMenus = new OrderMenus(input);
        Assertions.assertEquals(6, orderMenus.countDessertMenus());
    }

    @Test
    void 전체_메뉴중_메인_개수세기() {
        String input = "티본스테이크-5,레드와인-5,바비큐립-3,아이스크림-3";
        OrderMenus orderMenus = new OrderMenus(input);
        Assertions.assertEquals(8, orderMenus.countMainMenus());
    }
}