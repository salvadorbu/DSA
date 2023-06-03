package Algorithms;

public class BinarySearch {
    /**
     * Recursive implementation of binary search algorithm
     *
     * @param target     Value that you are searching for
     * @param values     Array of values to search
     * @param lowerBound Lower index bound
     * @param upperBound Upper index bound
     * @return The index where the value was found
     */
    public static int search(int target, int[] values, int lowerBound, int upperBound) {
        if (lowerBound > upperBound) {
            return -1;
        }

        int mid = (lowerBound + upperBound) / 2;

        if (values[mid] == target) {
            return mid;
        } else if (values[mid] < target) {
            return search(target, values, mid + 1, upperBound);
        } else {
            return search(target, values, lowerBound, mid - 1);
        }
    }

    public static void main(String[] args) {
        int[] values = new int[] {1, 3, 4, 6, 11, 25, 616};
        int lowerBound = 0;
        int upperBound = values.length - 1;
        int target = 25;

        System.out.println(search(target, values, lowerBound, upperBound));
    }
}
