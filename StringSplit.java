import java.util.regex.Pattern;
import java.util.StringTokenizer;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class StringSplit {
    public static void main(String[] args) {
        String s = "a | b | c | d";
        String regex = Pattern.quote("|");
        String[] arr = s.split("\\|");
        System.out.println(arr);

        String test = "Manchester United Football Club is owned by Sir Jim Ratcliffe";
        StringTokenizer st = new StringTokenizer(test); // whitespace by default
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }

        Stream<String> stringStream = Stream.of("foo", "bar", "foobar");
        String joined = stringStream.collect(Collectors.joining(",", "{", "}"));
        System.out.println(joined);

        StringBuilder sb = new StringBuilder("a");
        String sAppended = sb.append("b").append(2).toString();
        System.out.println(sAppended);

        /*
         * If we however, use a loop, each iteration of the loop creates a new
         * StringBuilder object
         * 
         * result += extractElement(array[i])
         * return result;
         * 
         * so instead, we can use
         * 
         * result.append(extractElement(array[i]) - this reuses a single instance of
         * StringBuilder
         * return result.toString();
         */

        StringBuilder buf = new StringBuilder(100);
        for (int i = 0; i < 100; i++) {
            buf.setLength(0);
            buf.append("This is line").append(i).append('\n');
            System.out.println(buf.toString());
        }
    }
}
