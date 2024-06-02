package JavaCodingProblems.DataStructures.Array;

public class HeapSort {
    public static void heapSort(int[] arr) {
        int n = arr.length;

        buildHeap(arr, n);
        while(n > 1) {
            swap(arr, 0, n-1);
            n--;
            heapify(arr, n, 0);
        }
    }

        private static void buildHeap(int[] arr, int n) {
            for(int i = arr.length/2 - 1; i >= 0; i--) {
                heapify(arr, n, i);
            }
        }

        private static void heapify(int[] arr, int n, int i) {
            int greater;
            int left = 2*i + 1;
            int right = 2*i + 2;

            if(left < n && arr[left] > arr[i]) {
                greater = left;
            } else {
                greater = i;
            }

            if(right < n && arr[right] > arr[greater]) {
                greater = right;
            }

            if(greater != i) {
                swap(arr, i, greater);
                heapify(arr, n, greater);
            }
        }

        private static void swap(int[] arr, int x, int y) {
            int temp = arr[x];
            arr[x] = arr[y];
            arr[y] = temp;
        }
    }






