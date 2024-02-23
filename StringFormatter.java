import java.util.Formatter;

public class StringFormatter {
    
    public static void main(String[] args) {
        int one = 1;
        String color = "red";
        Formatter f = new Formatter();
        System.out.print(f.format("One = %d, colour=%s%n", one, color));
        System.out.print(String.format("One = %d, colour=%s%n", one, color));
    }

}
