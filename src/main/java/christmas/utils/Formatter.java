package christmas.utils;

import java.text.DecimalFormat;

public class Formatter {
    private static final String WON_FORMAT = "#,###원";

    public static String formatToCurrencyWon(int price) {
        DecimalFormat format = new DecimalFormat(WON_FORMAT);
        return format.format(price);
    }
}
