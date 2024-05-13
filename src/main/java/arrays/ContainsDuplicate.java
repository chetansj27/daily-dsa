package arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

//Link - https://leetcode.com/problems/contains-duplicate
public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 4, 9};
        System.out.println(checkUsingMap(arr));
        System.out.println(checkUsingSet(arr));

    }

    private static boolean checkUsingSet(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int j : arr) {
            if (set.contains(j)) {
                return true;
            } else {
                set.add(j);
            }
        }
        return false;
    }

    private static boolean checkUsingMap(int[] arr) {
        Map<Integer, Integer> res = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (res.containsKey(arr[i])) {
                return true;
            } else {
                res.put(arr[i], i);
            }
        }
        return false;
    }
}
