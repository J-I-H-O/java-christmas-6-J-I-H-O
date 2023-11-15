package christmas.model.discount;

import christmas.utils.Formatter;

public class Discount {
    private final String name;
    private final int amount;

    public Discount(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(name)
                .append(": ")
                .append(Formatter.formatToCurrencyWon(-amount))
                .toString();
    }
}
