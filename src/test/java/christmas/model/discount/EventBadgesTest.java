package christmas.model.discount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EventBadgesTest {
    @Test
    void 총혜택_금액이_20000원_이상인_경우_산타() {
        int amount = 50000;
        String name = EventBadges.findBadgeNameByDiscountAmount(amount);
        Assertions.assertEquals("산타", name);
    }

    @Test
    void 총혜택_금액이_10000원_이상_20000원_미만인_경우_트리() {
        int amount = 15000;
        String name = EventBadges.findBadgeNameByDiscountAmount(amount);
        Assertions.assertEquals("트리", name);
    }

    @Test
    void 총혜택_금액이_5000원_이상_10000원_미만인_경우_별() {
        int amount = 7000;
        String name = EventBadges.findBadgeNameByDiscountAmount(amount);
        Assertions.assertEquals("별", name);
    }

    @Test
    void 총혜택_금액이_5000원_미만인_경우_없음() {
        int amount = 3000;
        String name = EventBadges.findBadgeNameByDiscountAmount(amount);
        Assertions.assertEquals("없음", name);
    }
}