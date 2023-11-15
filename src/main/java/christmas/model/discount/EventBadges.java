package christmas.model.discount;

public enum EventBadges {
    SANTA("산타", 20000),
    TREE("트리", 10000),
    STAR("별", 5000),
    NOTHING("없음", 0);

    private final String name;
    private final int criteria;

    EventBadges(String name, int criteria) {
        this.name = name;
        this.criteria = criteria;
    }

    public static String findBadgeNameByDiscountAmount(int discountAmount) {
        for (EventBadges badge : EventBadges.values()) {
            if (badge.criteria <= discountAmount) {
                return badge.name;
            }
        }
        return NOTHING.name;
    }
}
