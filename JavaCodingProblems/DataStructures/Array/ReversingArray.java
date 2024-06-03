package JavaCodingProblems.DataStructures.Array;

import java.util.stream.IntStream;




public class ReversingArray {
    int[] integers = {-1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

    public static void reversedArray(int[] array) {
        for(int left = 0, right  = array.length - 1; left < right; left++, right--){
            int elem = array[left];
            array[left] = array[right];
            array[right] = elem;
        }

       
    }

    int[] reversed = IntStream.rangeClosed(1, integers.length).map(i -> integers[integers.length - i]).toArray();

    public static<T> void reversedArray(T[] array) {
        for(int left = 0, right  = array.length - 1; left < right; left++, right--){
            T elem = array[left];
            array[left] = array[right];
            array[right] = elem;
        }

       
    }
}
