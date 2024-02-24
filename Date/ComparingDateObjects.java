package Date;

import java.util.Date;
import java.util.Calendar;
import java.time.LocalDate;

public class ComparingDateObjects {
    public static void main(String[] args) {
        /* 
         * all this is old stuff
         */

        final Date today = new Date();
        final Calendar calendar = Calendar.getInstance();
        calendar.set(1990, calendar.NOVEMBER, 1, 0, 0, 0);
        Date birthDate = calendar.getTime();

        final Calendar calendar2 = Calendar.getInstance();
        calendar2.set(1990, calendar2.NOVEMBER, 1, 0, 0, 0);
        Date birthDate2 = calendar2.getTime();

        //before
        System.out.printf("Is %1$tF before %2$tF? %3$b%n", today, birthDate,
        Boolean.valueOf(today.before(birthDate)));
        System.out.printf("Is %1$tF before %1$tF? %3$b%n", today, today,
        Boolean.valueOf(today.before(today)));
        System.out.printf("Is %2$tF before %1$tF? %3$b%n", today, birthDate,
        Boolean.valueOf(birthDate.before(today)));

        //compare
        System.out.printf("Compare %1$tF to %2$tF: %3$d%n", today, birthDate,
                Integer.valueOf(today.compareTo(birthDate)));
        System.out.printf("Compare %1$tF to %1$tF: %3$d%n", today, birthDate,
                Integer.valueOf(today.compareTo(today)));
        System.out.printf("Compare %2$tF to %1$tF: %3$d%n", today, birthDate,
                Integer.valueOf(birthDate.compareTo(today)));


        /*
         * newer stuff
         */

        final LocalDate today2 = LocalDate.now();
        final LocalDate birthDate3 = LocalDate.of(2012, 6, 30);
        final LocalDate birthDate4 = LocalDate.of(2012, 6, 30);

        // compareTo example
        System.out.printf("Compare %1$tF to %2$tF %3$d%n", today2, birthDate3,
                Integer.valueOf(today2.compareTo(birthDate3)));


    }

}
