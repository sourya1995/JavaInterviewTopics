package JavaCodingProblems.DataStructures.Array;

import java.util.Comparator;

public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

            }
        }
    }

    public static <T> void bubbleSortWithComparator(T arr[], Comparator<? super T> c) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (c.compare(arr[j], arr[j + 1]) > 0) {
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    class MelonComparator implements Comparator<Melon> {

        @Override
        public int compare(Melon m1, Melon m2) {
            return m1.getType().compareTo(m2.getType());
        }
    }

    Comparator<Melon> byType = Comparator.comparing(Melon::getType);
    Comparator<Melon> byTypeDesc = Comparator.comparing(Melon::getType).reversed();
    Comparator<Melon> byWeight = Comparator.comparing(Melon::getWeight);
    Comparator<Melon> byWeightDesc = Comparator.comparing(Melon::getWeight).reversed();

    public static void optimizedBubbleSort(int[] arr) {
        int n = arr.length;
        while (n != 0) {
            int swap = 0;
            for (int i = 1; i < n; i++) {
                if (arr[i - 1] > arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                    swap = i;

                }
            }
            n = swap;
        }
    }

    public static <T> void optimizedBubbleSort(T[] arr, Comparator<? super T> c) {
        int n = arr.length;
        while (n != 0) {
            int swap = 0;
            for (int i = 1; i < n; i++) {
                if (c.compare(arr[i - 1], arr[i]) > 0) {
                    T temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                    swap = i;

                }
            }
            n = swap;

        }
    }

}
