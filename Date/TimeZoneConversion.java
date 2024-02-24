package Date;

import java.util.Date;
import java.util.TimeZone;
import java.text.SimpleDateFormat;

public class TimeZoneConversion {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(TimeZone.getDefault().getDisplayName());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(date));
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Europe/London"));
        System.out.println(simpleDateFormat.format(date));
    }
}
