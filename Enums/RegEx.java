package Enums;

import java.util.function.Predicate;
import java.util.regex.Pattern;

enum RegEx implements Predicate<String> {

    UPPER("^[A-Z]+$"), LOWER("^[a-z]+$"), DIGIT("^[0-9]+$");

    private final Pattern pattern;

    private RegEx(final String pattern) {
        this.pattern = Pattern.compile(pattern);
    }

    @Override
    public boolean test(final String input) {
        // TODO Auto-generated method stub
        return this.pattern.matcher(input).matches();
    }


    public static void main(String[] args) {
        System.out.println(RegEx.UPPER.test("ABC"));
        System.out.println(RegEx.LOWER.test("abc"));
        System.out.println(RegEx.DIGIT.test("123"));
    }

}
