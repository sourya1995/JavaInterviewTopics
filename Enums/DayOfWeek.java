package Enums;

enum DayOfWeek {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;

    public static void main(String[] args) {
        String dayName = DayOfWeek.SUNDAY.name();
        System.out.println(dayName);

        DayOfWeek day = DayOfWeek.valueOf("SUNDAY");
        System.out.println(day);
    }
}
