package Strings;
public class ReverseStrings {
    public static void main(String[] args) {
        String code = "code";
        System.out.println(code);
        StringBuilder sb = new StringBuilder(code);
        String codeReversed = sb.reverse().toString();
        System.out.println(codeReversed);

        /* using character array */
        char[] charArray = code.toCharArray();
        for (int i = 0, mirroredIndex = charArray.length - 1; i < mirroredIndex; i++, mirroredIndex--) {
            char temp = charArray[i];
            charArray[i] = charArray[mirroredIndex];
            charArray[mirroredIndex] = temp;
        }
        System.out.println(String.valueOf(charArray));
    }
}
