package JavaCodingProblems.Basics;

public class ConcatenateNTimes {
    public static String concatRepeat(String str, int n){
        StringBuilder sb = new StringBuilder(str.length() * n);
        for (int i = 1; i < n; i++) {
            sb.append(str);
        }

        return sb.toString();
    }
}
