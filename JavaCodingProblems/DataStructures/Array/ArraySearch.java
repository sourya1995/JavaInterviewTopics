package JavaCodingProblems.DataStructures.Array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class ArraySearch {

    int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    public static boolean containsElement(int[] arr, int toContain) {
        for (int elem : arr) {
            if (elem == toContain) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsElementV2(int[] arr, int toContain) {
        Arrays.sort(arr);
        int index = Arrays.binarySearch(arr, toContain);
        if (index < 0) {
            return false;
        }
        return true;

    }

    public static boolean containsElementJava8(int[] arr, int toContain) {
        return Arrays.stream(arr).anyMatch(elem -> elem == toContain);

    }

    public static <T> boolean containsElementObject(T[] arr, T toContain) {
        for (T elem : arr) {
            if (elem.equals(toContain)) {
                return true;
            }

        }

        return false;
    }

    public static <T> boolean containsElementObjectV2(T[] arr, T toContain, Comparator<? super T> c) {
        for (T elem : arr) {
            if (c.compare(elem, toContain) == 0) {
                return true;
            }

        }

        return false;
    }

    public static <T> boolean containsElementObjectV3(T[] arr, T toContain, Comparator<? super T> c) {
        Arrays.sort(arr, c);
        int index = Arrays.binarySearch(arr, toContain, c);
        if (index < 0) {
            return false;
        }
        return true;

    }

    public static int findIndexOfElement(int[] arr, int toFind) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == toFind) {
                return i;
            }
        }
        return -1;
    }

    public static int findIndexOfElementJava8(int[] arr, int toFind) {
        return IntStream.range(0, arr.length).filter(i -> arr[i] == toFind).findFirst().orElse(-1);

    }

    public static <T> int findIndexOfElementObject(T[] arr, T toFind) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(toFind)) {
                return i;
            }
        }
        return -1;
    }

    public static <T> int findIndexOfElementObject(T[] arr, T toFind, Comparator<? super T> c) {
        for (int i = 0; i < arr.length; i++) {
            if (c.compare(arr[i], toFind) == 0) {
                return i;
            }
        }
        return -1;
    }

    public static <T> int findIndexOfElementObjectJava8(T[] arr, T toFind, Comparator<? super T> c) {
        return IntStream.range(0, arr.length).filter(i -> c.compare(arr[i], toFind) == 0).findFirst().orElse(-1);
    }

}
