package Leetcode;

import java.util.*;

/**
 * Bruh
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<List<Integer>, List<String>> map = new HashMap<List<Integer>, List<String>>();

        for (String str : strs) {
            List<Integer> arrList = new ArrayList<Integer>();
            for (int i = 0; i < 26; i++) {
                arrList.add(i, 0);
            }
            for (char c : str.toCharArray()) {
                arrList.set(c - 97, arrList.get(c - 97) + 1);
            }

            if (map.containsKey(arrList)) {
                map.get(arrList).add(str);
            } else {
                List<String> newStringList = new ArrayList<String>();
                newStringList.add(str);
                map.put(arrList, newStringList);
            }
        }

        return new ArrayList<List<String>>(map.values());
    }
}
