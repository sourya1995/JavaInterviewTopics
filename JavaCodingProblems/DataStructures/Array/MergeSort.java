package JavaCodingProblems.DataStructures.Array;

public class MergeSort {

    public static void mergeSort(int[] array){
        if(array.length > 1){
            int middle = array.length / 2;
            int[] leftArray = new int[middle];
            System.arraycopy(array, 0, leftArray, 0, middle);

            int[] rightArray = new int[array.length - middle];
            System.arraycopy(array, middle, rightArray, 0, array.length - middle);

            mergeSort(leftArray);
            mergeSort(rightArray);

            merge(array, leftArray, rightArray);

        }
    }
    
    private static void merge(int[] array, int[] leftArray, int[] rightArray){
        int leftIndex = 0, rightIndex = 0, mergeIndex = 0;

        while(leftIndex < leftArray.length && rightIndex < rightArray.length){
            if(leftArray[leftIndex] <= rightArray[rightIndex]){
                array[mergeIndex++] = leftArray[leftIndex++];
            }else{
                array[mergeIndex++] = rightArray[rightIndex++];
            }
        }

        while(leftIndex < leftArray.length){
            array[mergeIndex++] = leftArray[leftIndex++];
        }

        while(rightIndex < rightArray.length){
            array[mergeIndex++] = rightArray[rightIndex++];

        }
    }
}
