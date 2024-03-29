package Time;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.OffsetDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.Clock;
import java.time.format.DateTimeFormatter;

public class TimeUtils {
    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.of(2016, Month.JULY, 27, 8, 0);
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime parsed = LocalDateTime.parse("2016-07-27T10:15:30");
        System.out.println(dateTime);
        System.out.println(now);
        System.out.println(parsed);

        ZoneId zoneId = ZoneId.of("UTC+2");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(2016, 7, 27, 7, 0, 0, 235, zoneId);
        System.out.println(zonedDateTime);

        ZoneOffset zoneOffset = ZoneOffset.ofHours(2);
        OffsetDateTime offsetDateTime = OffsetDateTime.now();

        LocalDate tomorrow = LocalDate.now().plusDays(1);
        System.out.println(tomorrow);
        LocalDateTime anHourFromNow = LocalDateTime.now().plusHours(1);
        System.out.println(anHourFromNow);
        Long daysBetween = ChronoUnit.DAYS.between(LocalDate.now(), LocalDate.now().plusDays(3));
        System.out.println(daysBetween);

        LocalDateTime ldt2 = LocalDateTime.now(Clock.system(ZoneId
                .of(ZoneId.SHORT_IDS.get("PST"))));
        System.err.println(ldt2);

        Clock clock = Clock.systemUTC();
        System.out.println(clock.instant());

        String pattern = "d-MM-yyyy HH:mm";
        DateTimeFormatter dtF1 = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime ldp2 = LocalDateTime.parse("15-05-2016 13:55", dtF1);
        System.out.println(ldp2);
    }
}
