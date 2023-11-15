package christmas.model.menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuInfoTest {
    @Test
    void 메뉴판에_없는_메뉴_주문시_예외발생() {
        String menuInput = "없는메뉴";
        Assertions.assertThrows(IllegalArgumentException.class, () -> MenuInfo.findMenuInfoByName(menuInput));
    }

    @Test
    void 메뉴판에_있는_메뉴_주문시_MenuInfo_객체_반환() {
        String menuInput = "초코케이크";
        Assertions.assertTrue(MenuInfo.findMenuInfoByName(menuInput) instanceof MenuInfo);
    }
}