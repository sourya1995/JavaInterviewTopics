package Currency;

import java.text.NumberFormat;
import java.util.Locale;


public class NumberFormatExample {
    public static void main(String[] args) {
        Locale locale = new Locale("en", "US");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        NumberFormat percentFormatter = NumberFormat.getPercentInstance();
        currencyFormatter.format(10.99);
        percentFormatter.format(0.1);
        System.out.println(currencyFormatter.format(10.99));
        System.out.println(percentFormatter.format(0.1));
    }
}
