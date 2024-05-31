package Date;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.time.ZoneOffset;
import java.time.OffsetTime;
import java.time.temporal.ChronoUnit;



public class DateToLocalDateAndViceVersaConversion {

    static ZoneId defaultZoneId = ZoneId.systemDefault();

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

    public static Instant dateToInstant(Date date) {
        return date.toInstant();
    }

    public static Date instantToDate(Instant instant) {
        return Date.from(instant);
    }

    public static LocalDate dateToLocalDate(Date date) {
        return dateToInstant(date).atZone(defaultZoneId).toLocalDate();
    }

    public static Date localDateToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
    }

    public static LocalDateTime dateToLocalDateTime(Date date) {
        return dateToInstant(date).atZone(defaultZoneId).toLocalDateTime();
    }

    public static Date localDateTimeToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(defaultZoneId).toInstant());
    }

    public static ZonedDateTime dateToZonedDateTime(Date date) {
        return dateToInstant(date).atZone(defaultZoneId);
    }

    public static Date zonedDateTimeToDate(ZonedDateTime zonedDateTime) {
        return Date.from(zonedDateTime.toInstant());
    }

    public static OffsetDateTime dateToOffsetDateTime(Date date) {
        return dateToInstant(date).atZone(defaultZoneId).toOffsetDateTime();
    }

    public static Date offsetDateTimeToDate(OffsetDateTime offsetDateTime) {
        return Date.from(offsetDateTime.toLocalDateTime().toInstant(ZoneOffset.of(offsetDateTime.getOffset().getId())));
    }

    public static LocalTime dateToLocalTime(Date date) {
        return LocalTime.ofInstant(dateToInstant(date), defaultZoneId);
    }

    public static Date localTimeToDate(LocalTime localTime) {
        return Date.from(localTime.atDate(LocalDate.EPOCH)
                .toInstant(defaultZoneId.getRules()
                        .getOffset(Instant.now())));

    }

    public static OffsetTime dateToOfffsetTime(Date date){
        return OffsetTime.ofInstant(dateToInstant(date), defaultZoneId);
    }

    public static Date offsetTimeToDate(OffsetTime offsetTime){
        return Date.from(offsetTime.atDate(LocalDate.EPOCH).toInstant());
    }

    public Pair<ZonedDateTime, ZonedDateTime> getDayStartEnd(LocalDate date, ZoneId zoneId){
        ZonedDateTime startOfDay = date.atStartOfDay(zoneId);
        ZonedDateTime endOfDay = date.atTime(LocalTime.MAX).atZone(zoneId);

        if(startOfDay.toLocalDateTime().plus(1, ChronoUnit.DAYS).isAfter(endOfDay.toLocalDateTime())){
            endOfDay = endOfDay.minusHours(1);
        }

        return new Pair<>(startOfDay, endOfDay);
    }


    class Pair<A, B> {
        private final A first;
        private final B second;

        /* Constructor */
        public Pair(A first, B second) {
            this.first = first;
            this.second = second;
        }

        /* Getter */
        public A getFirst() {
            return first;
        }

        /* Getter */
        public B getSecond() {
            return second;
        }

    }

}
