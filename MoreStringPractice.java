public class MoreStringPractice {

    public static void main(String[] args) {
        String strObj = new String("Hello");
        String str = "Hello!";

        if (strObj.equals(str)) {
            System.out.println("They are equal");
        }
        
        if (strObj != str) {
            System.out.println("The strings are not the same object");
        }
        
        String internedString = strObj.intern();
        if (internedString == str) {
            System.out.println("The strings are the same object");
        }
    }

}
