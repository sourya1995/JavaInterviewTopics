package JavaCodingProblems.DataStructures.Array;

import java.util.Comparator;



public class InsertionSort {

    public static void insertionSort(int arr[]){
        int n = arr.length;
        for (int i = 1; i < n; ++i){
            int key = arr[i]; // [5, 2, 4, 6, 1, 3] key = 2 j = 1
            int j = i - 1;

            while(j >= 0 && arr[j] > key){
                arr[j + 1] = arr[j]; //swap next with previous
                j = j - 1;
            }

            arr[j+1] = key;
        }

    }

    public static<T> void insertionSortWithComparator(T arr[], Comparator<? super T> comparator){
        int n = arr.length;
        for(int i = 1; i < n; i++){
            T key = arr[i];
            int j = i - 1;
            while(j >= 0 && comparator.compare(arr[j], key) > 0){
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }

    }

    Comparator<Melon> byType = Comparator.comparing(Melon::getType).thenComparing(Melon::getWeight);
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}