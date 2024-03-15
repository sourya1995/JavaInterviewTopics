package Date.Calendar;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarClass {
    public static void main(String[] args) {
        Calendar calendar = new GregorianCalendar(2016, Calendar.MARCH, 31);
        calendar.add(Calendar.MONTH, 6);

        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c2.set(Calendar.DATE, c2.get(Calendar.DATE) + 1);
        System.out.println(c2.getTimeInMillis() - c1.getTimeInMillis());

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        if(cal.get(Calendar.AM_PM) == Calendar.PM)
            System.out.println("It is PM");
    }
}
