package Date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class UtilToSqlConversion {
    public static void main(String[] args) {
        java.util.Date utilDate = new java.util.Date();
        System.out.println("java.util.Date is:" + utilDate);
        java.sql.Date sqlDate = convert(utilDate);
        System.out.println("java.sql.Date is:" + sqlDate);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY - hh:mm:ss");
        System.out.println("Formatted date is:" + dateFormat.format(utilDate));
    }

    private static java.sql.Date convert(java.util.Date someDate) {
        java.sql.Date date = new java.sql.Date(someDate.getTime());
        return date;
    }

}
