package arrays;

import java.util.HashSet;


public class FindXOROfNumberAppearTwice {
    public static void main(String[] args) {

    }

    public static int find(int[] nums) {
        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num))
                res = res ^ num;
            else
                set.add(num);
        }
        return res;
    }
}
