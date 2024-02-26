package Arrays;

import java.util.Arrays;

public class ToString {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        System.out.println(arr);
        System.out.println(Arrays.toString(arr)); // for 2D arrays, use Arrays.deepToString()

        /* Arrays.toString() uses Object.toString() */
    }
}
