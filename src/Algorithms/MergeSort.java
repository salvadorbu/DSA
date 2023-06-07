package Algorithms;

public class MergeSort extends DSASort {

    public static void sort(int[] arr) {
        int length = arr.length;

        if (length < 2) {
            return;
        }

        int midIndex = length / 2;
        int[] leftHalf = new int[midIndex];
        int[] rightHalf = new int[length - midIndex];

        for (int i = 0; i < midIndex; i++) {
            leftHalf[i] = arr[i];
        }

        for (int i = midIndex; i < length; i++) {
            rightHalf[i - midIndex] = arr[i];
        }

        sort(leftHalf);
        sort(rightHalf);

        merge(arr, leftHalf, rightHalf);
    }

    private static void merge(int[] merged, int[] leftArr, int[] rightArr) {
        int i = 0, j = 0, k = 0;

        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] < rightArr[j]) {
                merged[k] = leftArr[i];
                i++;
            } else {
                merged[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < leftArr.length) {
            merged[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < rightArr.length) {
            merged[k] = rightArr[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] testArr = new int[]{3, 1, 35, 94, 12, 16, 63, 100};
        printArray(testArr);
        sort(testArr);
        printArray(testArr);
    }
}
