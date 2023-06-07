package Leetcode;

import java.util.*;

public class TopKFrequent {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        int[] arr = new int[20001];
        int offset = 10000;

        for (int num : nums) {
            arr[offset + num]++;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                map.put(arr[i], i);
            }
        }

        int[] sol = new int[k];
        int setSize = map.keySet().size();
        for (int i = 0; i < k; i++) {
            sol[i] = map.get(Integer.valueOf((Integer)map.keySet().toArray()[setSize - 1 - i])) - offset;
        }

        return sol;
    }

    public static void main(String[] args) {
        int[] sampleArray = new int[]{1,1,1,2,2,3};
        int k = 2;
        int[] solution = topKFrequent(sampleArray, k);
        for (int num : solution) {
            System.out.println(num);
        }
    }
}
