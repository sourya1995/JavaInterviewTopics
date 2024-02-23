public class RepeatStringNTimes {
    public static void main(String[] args) {
        // execute statements here
        final int n = 4;
        final String s = "incredible, sensational";
        String result = "";

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < n; i++) {
            // result += s; //creates a new string each time
            builder.append(s);
        }
        String res = builder.toString();
        System.out.println(res);
    }
}
