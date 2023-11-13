package christmas.config;

public enum EventDate {
    DECEMBER_2023(2023, 12);

    private final int year;
    private final int month;

    EventDate(int year, int month) {
        this.year = year;
        this.month = month;
    }

    public int getEventMonth() {
        return month;
    }

    public int getEventYear() {
        return year;
    }
}
