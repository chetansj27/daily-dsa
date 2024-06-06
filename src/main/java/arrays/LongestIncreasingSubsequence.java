package arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = { 2, 5, 3, 7, 101, 18};
        calculate(nums);
    }

    public static void calculate(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    count++;
                }
            }
            max = Math.max(max, count);
        }
        System.out.println(max);
    }

}
