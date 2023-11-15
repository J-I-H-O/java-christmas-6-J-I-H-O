package christmas.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FormatterTest {
    @Test
    void 숫자_입력시_1000원_단위로_포맷팅() {
        int value = 1000000;
        String formatted = Formatter.formatToCurrencyWon(value);
        Assertions.assertEquals("1,000,000원", formatted);
    }

    @Test
    void 천원_미만의_금액은_그대로_출력() {
        int value = 999;
        String formatted = Formatter.formatToCurrencyWon(value);
        Assertions.assertEquals("999원", formatted);
    }
}