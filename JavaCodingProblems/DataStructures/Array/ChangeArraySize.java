package JavaCodingProblems.DataStructures.Array;

import java.util.Arrays;

public class ChangeArraySize {

    public static int[] add(int[] arr, int item) {
        int[] newArr = Arrays.copyOf(arr, arr.length + 1);
        newArr[newArr.length - 1] = item;

        return newArr;

    }

    public static<T> T[] addObject(T[] arr, T item) {
        T[] newArr = Arrays.copyOf(arr, arr.length + 1);
        newArr[newArr.length - 1] = item;

        return newArr;

    }

    public static int[] remove(int[] arr, int item) {
        int[] newArr = Arrays.copyOf(arr, arr.length - 1);

        return newArr;
    }

    public static<T> T[] removeObject(T[] arr, T item) {
        T[]newArr = Arrays.copyOf(arr, arr.length - 1);

        return newArr;
    }

    public static int[] resize(int[] arr, int length) {
        int[] newArr = Arrays.copyOf(arr, arr.length + length);

        return newArr;

    }

    public static<T> T[] resize(T[] arr, int length) {
        T[] newArr = Arrays.copyOf(arr, arr.length + length);

        return newArr;

    }


}
