package arrays;

import java.util.HashMap;
import java.util.Map;

public class FindOccurrencesofanElementinanArray {
    public static void main(String[] args) {
        int[] nums = {1, 3, 1, 7};
        int[] queries = {1, 3, 2, 4};
        System.out.println(occurrencesOfElement(nums, queries, 1));
    }

    public static int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int occur = 1;
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[queries.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == x) {
                map.put(occur, i);
                occur++;
            }
        }
        for (int i = 0; i < queries.length; i++) {
            res[i] = map.getOrDefault(queries[i], -1);
        }
        return res;
    }
}
