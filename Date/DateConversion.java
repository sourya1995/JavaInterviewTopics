package Date;

import java.util.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class DateConversion {
    Date date = Date.from(Instant.now());
    ZoneId defaultZoneId = ZoneId.systemDefault();

    LocalDate localDate = date.toInstant().atZone(defaultZoneId).toLocalDate(); // Date to LocalDate
    Date localDate2 = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

    LocalDateTime localDateTime =date.toInstant().atZone(defaultZoneId).toLocalDateTime();
    Date localDate3 = Date.from(localDateTime.atZone(defaultZoneId).toInstant());
}
