package christmas.config;

public enum BadgeType {
    STAR("별", 5000),
    TREE("트리", 10000),
    SANTA("산타", 20000);

    private final String badgeName;
    private final int thresholdAmount;

    BadgeType(String badgeName, int thresholdAmount) {
        this.badgeName = badgeName;
        this.thresholdAmount = thresholdAmount;
    }

    public String getBadgeName() {
        return badgeName;
    }

    public int getThresholdAmount() {
        return thresholdAmount;
    }
}
