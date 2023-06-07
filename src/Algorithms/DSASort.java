package Algorithms;

public class DSASort {
    public static void sort(int[] arr) { return; };

    public static void printArray(int[] arr) {
        System.out.print("[");
        boolean isFirst = true;

        for (int num : arr) {
            if (isFirst) {
                System.out.print(num);
                isFirst = false;
            } else {
                System.out.print(", " +  num);
            }
        }

        System.out.print("]");
        System.out.println();
    }
}
