    package christmas.model;

    import java.time.DayOfWeek;
    import java.time.LocalDate;
    import java.time.Month;

    public enum SpecialDiscountEvent {
        CALENDAR_STAR("특별 할인", 1000),
        NONE("없음", 0);

        private final String discountName;
        private final int discountAmount;

        SpecialDiscountEvent(String discountName, int discountAmount) {
            this.discountName = discountName;
            this.discountAmount = discountAmount;
        }

        public String getDiscountName() {
            return discountName;
        }

        public int getDiscountAmount() {
            return discountAmount;
        }

        public static SpecialDiscountEvent calculateSpecialDiscount(LocalDate orderDate) {
            if (isSaturday(orderDate) || isChristmasDay(orderDate)) {
                return CALENDAR_STAR;
            }
            return NONE;
        }

        private static boolean isSaturday(LocalDate date) {
            return date.getDayOfWeek() == DayOfWeek.SATURDAY;
        }

        private static boolean isChristmasDay(LocalDate date) {
            return date.getMonth() == Month.DECEMBER && date.getDayOfMonth() == 25;
        }
    }
