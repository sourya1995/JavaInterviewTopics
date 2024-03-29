package Date;

import java.util.Date;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.Instant;

public class DateToLocalDateAndViceVersaConversion {
    public static void main(String[] args) {
        Date date = Date.from(Instant.now());
        ZoneId defaultZoneId = ZoneId.systemDefault();
        System.out.println(defaultZoneId); // Asia/Kolkata

        LocalDate localDate = date.toInstant().atZone(defaultZoneId).toLocalDate(); // Date to LocalDate
        Date localDate2 = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

        LocalDateTime localDateTime = date.toInstant().atZone(defaultZoneId).toLocalDateTime();
        System.out.println(localDateTime);
        Date localDate3 = Date.from(localDateTime.atZone(defaultZoneId).toInstant());
        System.out.println(localDate3);

        LocalTime localTime = LocalTime.now();
        Instant instant = localTime.atDate(localDate).atZone(defaultZoneId).toInstant();
        Date date1 = Date.from(instant);
        System.out.println(date1);
    }

}
