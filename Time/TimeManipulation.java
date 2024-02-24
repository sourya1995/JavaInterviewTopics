package Time;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.ZoneId;
import java.time.Duration;

public class TimeManipulation {
    public static void main(String[] args) {
        LocalTime start = LocalTime.of(1, 0, 0);
        LocalTime end = LocalTime.of(2, 10, 20);

        long halfDays1 = start.until(end, ChronoUnit.HALF_DAYS);
        long halfDays2 = ChronoUnit.HALF_DAYS.between(start, end);

        System.out.println(halfDays1);
        System.out.println(halfDays2);

        long hours1 = start.until(end, ChronoUnit.HOURS);
        long hours2 = ChronoUnit.HOURS.between(start, end);

        System.out.println(hours1);
        System.out.println(hours2);

        long minutes1 = start.until(end, ChronoUnit.MINUTES);
        long minutes2 = ChronoUnit.MINUTES.between(start, end);

        System.out.println(minutes1);
        System.out.println(minutes2);

        long seconds1 = start.until(end, ChronoUnit.SECONDS);
        long seconds2 = ChronoUnit.SECONDS.between(start, end);

        System.out.println(seconds1);
        System.out.println(seconds2);

        long millis1 = start.until(end, ChronoUnit.MILLIS);
        long millis2 = ChronoUnit.MILLIS.between(start, end);

        System.out.println(millis1);
        System.out.println(millis2);

        long nanos1 = start.until(end, ChronoUnit.NANOS);
        long nanos2 = ChronoUnit.NANOS.between(start, end);

        System.out.println(nanos1);
        System.out.println(nanos2);

        /*
         * long days1 = start.until(end, ChronoUnit.DAYS);
         * long days2 = ChronoUnit.DAYS.between(start, end);
         * 
         * System.out.println(days1);
         * System.out.println(days2);
         */
        ZoneId zone1 = ZoneId.of("Europe/Berlin");
        ZoneId zone2 = ZoneId.of("Brazil/East");

        LocalTime now1 = LocalTime.now(zone1);
        LocalTime now2 = LocalTime.now(zone2);
        LocalTime now3 = LocalTime.now();

        long minutesBetween = ChronoUnit.MINUTES.between(now1, now2);
        long minutesBetween2 = ChronoUnit.MINUTES.between(now1, now3);

        System.out.println(minutesBetween);
        System.out.println(minutesBetween2);

        long minutesBetween4 = Duration.between(now1, now2).toMinutes();
        long minutesBetween5 = Duration.between(now1, now3).toMinutes();

        System.out.println(minutesBetween4);
        System.out.println(minutesBetween5);

    }
}
