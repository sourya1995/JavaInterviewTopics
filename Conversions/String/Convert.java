package Conversions.String;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

public class Convert {
    public static void main(String[] args) {
        String number = "12";
        int num = Integer.parseInt(number);
        float numF = Float.parseFloat(number);
        double numD = Double.parseDouble(number);
        long numL = Long.parseLong(number);
        System.out.println(num + "," + numF + "," +  numD + "," + numL);

        String falseString = "false";
        boolean falseBool = Boolean.parseBoolean(falseString);

        String bigNumber = "21";
        BigInteger prettyBig = new BigInteger(bigNumber);
        //NumberFormatException is an unchecked exception that cannot be handled properly

        // tryParseInt("42");

        int i = 42;
        String string = String.valueOf(i);
        //this works for float, double, boolean and Object

    }

  /*   boolean tryParseInt(String value){
        try {
            String somechar = Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    } */

    public String readString(InputStream input) throws IOException{
        byte[] bytes = new byte[50];
        input.read(bytes);
        return new String(bytes, StandardCharsets.UTF_8);
    }
}
