package JavaCodingProblems.DataStructures.Array;

public class QuickSort {

    public static void quicksort(int[] array) {
        quicksort(array, 0, array.length - 1);
    }

    private static void quicksort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quicksort(array, low, pivotIndex - 1);
            quicksort(array, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int smallerElementIndex = low - 1;
        for (int currentIndex = low; currentIndex < high; currentIndex++) {
            if (array[currentIndex] <= pivot) {
                smallerElementIndex++;
                int temp = array[smallerElementIndex];
                array[smallerElementIndex] = array[currentIndex];
                array[currentIndex] = temp;
            }
        }
        int temp = array[smallerElementIndex + 1];
        array[smallerElementIndex + 1] = array[high];
        array[high] = temp;
        return smallerElementIndex + 1;
    }

}
