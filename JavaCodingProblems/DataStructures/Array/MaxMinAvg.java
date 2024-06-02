package JavaCodingProblems.DataStructures.Array;

import java.util.Arrays;
import java.util.Comparator;

public class MaxMinAvg {

    public static int max(int[] arr) {
        int max = arr[0];
        for (int elem : arr) {
            if (elem > max) {
                max = elem;
            }
        }
        return max;
    }

    private int[] arr;

    int maxInt = Arrays.stream(arr).max().getAsInt(); //java 8 style

    public static<T extends Comparable<T>> T max(T[] arr) {
        T max = arr[0];
        for (T elem : arr) {
            if (elem.compareTo(max) > 0) {
                max = elem;
            }
        }
        return max;
    }

    public static<T> T max(T[] arr, Comparator<? super T> c){
        T max = arr[0];
        for (T elem : arr) {
            if (c.compare(elem, max) > 0) {
                max = elem;
            }
        }
        return max;

    }

    public static double average(int[] arr){
        return sum(arr)/ arr.length;
    }

    public static double sum(int[] arr){
        double sum = 0;
        for (int elem : arr) {
            sum += elem;
        }
        return sum;

    }

    double average = Arrays.stream(arr).average().getAsDouble();


         

}
