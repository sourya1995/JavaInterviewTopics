public class StringBufferExample {
    public static void main(String[] args) {
        String str = "study";
        str.concat("tonight");
        System.out.println(str); //study - because str.concat() would require separate object

        StringBuffer strB = new StringBuffer("study");
        strB.append("tonight");
        System.out.println(strB); //study tonight
    }
}
