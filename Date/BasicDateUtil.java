package Date;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.LocalDateTime;

public class BasicDateUtil {
    public static void main(String[] args) {
        String formatString = "yyyy/MM/dd hh:mm:ss";
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat(formatString);
        String formattedDate = dateFormat.format(date);
        System.out.println(formattedDate);

        /* OR */
        System.out.println(new SimpleDateFormat("yyyy/MM/dd hh:mm:ss").format(Calendar.getInstance().getTime()));

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        Date date2 = new Date();
        System.out.println(date2);

        Date date3 = Calendar.getInstance().getTime();
        System.out.println(date3);

        Date date4 = GregorianCalendar.getInstance().getTime();
        System.out.println(date4);

        localDate = LocalDate.of(2017, 12, 15);
        System.out.println(localDate); // 2017-12-15

        localDate = LocalDate.parse("2017-12-15");
        System.out.println(localDate); // 2017-12-15

        LocalDate localDate2 = LocalDate.now(ZoneId.systemDefault());
        System.out.println(localDate2);

        LocalDateTime ldatetime = LocalDateTime.now();
        System.out.println(ldatetime);

        ldatetime = LocalDateTime.of(2017, 12, 15, 11, 30);
        System.out.println(ldatetime);

        ldatetime = LocalDateTime.parse("2017-12-15T11:30");
        System.out.println(ldatetime);

        LocalDateTime ldatetime2 = LocalDateTime.now(ZoneId.systemDefault());
        System.out.println(ldatetime2);

    }
}
