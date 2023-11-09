package christmas.config;

public enum EventMonth {
    DECEMBER(12);

    private final int month;

    EventMonth(int month) {
        this.month = month;
    }

    public int getEventMonth() {
        return month;
    }
}
