package Arrays;

import java.util.Arrays;

public class PrimitiveToBoxedAndViceVersa {
    public static void main(String[] args) {
        int[] primitiveArray = { 1, 2, 3, 4, 5 };
        // Method 1 - Java 8
        Integer[] boxedArray = Arrays.stream(primitiveArray).boxed().toArray(Integer[]::new);
        System.out.println(Arrays.toString(boxedArray));

        // Method 2 - Java 7
        Integer[] boxedArray2 = new Integer[primitiveArray.length];
        for (int i = 0; i < primitiveArray.length; i++) {
            boxedArray2[i] = primitiveArray[i];
        }
        System.out.println(Arrays.toString(boxedArray2));

        Integer[] boxedIntegers = { 1, 2, 3, 4, 5 };
        //method 1 - Java 8
        int[] primitiveArray2 = Arrays.stream(boxedIntegers).mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(primitiveArray2));

        //method 2 - Java 7
        int[] primitiveArray3 = new int[boxedIntegers.length];
        for (int i = 0; i < boxedIntegers.length; i++) {
            primitiveArray3[i] = boxedIntegers[i];
        }
        System.out.println(Arrays.toString(primitiveArray3));


        
    }

}
