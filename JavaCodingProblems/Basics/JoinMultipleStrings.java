package JavaCodingProblems.Basics;

import java.util.Arrays;
import java.util.stream.Collectors;


public class JoinMultipleStrings {
    public static String joinByDelimiter(char delimiter, String...args){
        StringBuilder result = new StringBuilder();
        int i = 0;
        for(i=0; i<args.length - 1; i++){
            result.append(args[i]).append(delimiter);
        }
        result.append(args[i]);

        return result.toString();

    }

    public static String joinByDelimiterJava8(char delimiter, String...args){
        return Arrays.stream(args, 0, args.length).collect(Collectors.joining(String.valueOf(delimiter)));
    }
}
