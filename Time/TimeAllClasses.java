package Time;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.TimeZone;

public class TimeAllClasses {
    public static void checkLocalDateTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("Local Date time using static now() method ::: >>> " +
            localDateTime);
        LocalDateTime ldt1 = LocalDateTime.now(ZoneId.of(ZoneId.SHORT_IDS
            .get("AET")));
        System.out
            .println("LOCAL TIME USING now(ZoneId zoneId) method ::: >>>>" +
                ldt1);
        LocalDateTime ldt2 = LocalDateTime.now(Clock.system(ZoneId
            .of(ZoneId.SHORT_IDS.get("PST"))));
        System.out
            .println("Local TIME USING now(Clock.system(ZoneId.of())) ::: >>>> " +
                ldt2);
        System.out
            .println("Following is a static map in ZoneId class which has mapping of short timezone
                names to their Actual timezone names ");
                System.out.println(ZoneId.SHORT_IDS);
            }

    public static void checkLocalDate() {
            LocalDate localDate = LocalDate.now();
            System.out.println("Gives date without Time using now() method. >> " +
                localDate);
            LocalDate localDate2 = LocalDate.now(ZoneId.of(ZoneId.SHORT_IDS
                .get("ECT")));
            System.out
                .println("now() is overridden to take ZoneID as parametere using this we can get the
                    same date under different timezones. >> " +
                    localDate2);
    }
}