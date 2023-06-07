package Algorithms;

public class QuickSort extends DSASort {
    public static void sort(int[] arr, int low, int high) {

        if (low >= high) {
            return;
        }

        int pivot = arr[high];

        int left = low;
        int right = high;

        while (left < right) {
            while (arr[left] <= pivot && left < right) {
                left++;
            }

            while (arr[right] >= pivot && left < right) {
                right--;
            }

            swap(arr, left, right);
        }

        swap(arr, left, high);

        sort(arr, low, left - 1);
        sort(arr, left + 1, high);
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void main(String[] args) {
        int[] testArr = new int[]{51, 21, 9, 15, 101, 81, 153, 100};
        printArray(testArr);
        sort(testArr, 0, testArr.length - 1);
        printArray(testArr);
    }
}
