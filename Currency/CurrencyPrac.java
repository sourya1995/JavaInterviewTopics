package Currency;

import java.math.BigDecimal;

public class CurrencyPrac {
    public static void main(String[] args) {
        BigDecimal d = new BigDecimal(5);
        d.compareTo(new BigDecimal(4));
        d.equals(new BigDecimal(5)); //true
        d.equals(new BigDecimal(5.00)); //false
    }
}
