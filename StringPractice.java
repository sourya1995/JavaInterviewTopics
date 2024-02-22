import java.util.Locale;

public class StringPractice {
    public static void main(String[] args) {
        String firstString = "Test123";
        String secondString = "Test" + 123;
        String thirdString = "TEST123";
        String fourthString = "Taki";
        String fifthString = "TAKI";

        if(firstString.equals(secondString)){
            System.out.println("Both strings have same content");
        }

        if(firstString.equalsIgnoreCase(thirdString)){
            System.out.println("Both strings have same content ignoring case");
        }

        Locale locale = Locale.forLanguageTag("tr-TR");
        System.out.println(fourthString.toLowerCase(locale).equals(secondString.toLowerCase(locale))); //false
        
    }
    

}