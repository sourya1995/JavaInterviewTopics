package Recursion;

public class Reverse {
    public static void main(String[] args) {
        String s = "Hello";
        System.out.println(reverse(s));
    }
    public static String reverse(String s){
        if(s.length() == 1){
            return s;
        }else {
            return reverse(s.substring(1)) + s.charAt(0);
        }
    }
}
