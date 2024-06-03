package JavaCodingProblems.DataStructures.Array;

public class NextGreaterElement {

    public static void printNextGreaterElement(int[] arr) {
        int nge;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            nge = -1;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] < arr[j]) {
                    nge = arr[j];
                    break;
                }
            }
            System.out.println(arr[i] + " -> " + nge);
        }
    }
}
