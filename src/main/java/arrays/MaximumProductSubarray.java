package arrays;

public class MaximumProductSubarray {
    public static void main(String[] args) {

    }

    public int maxProduct(int[] nums) {
        int prefix = 1;
        int suffix = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (prefix == 0)
                prefix = 1;
            if (suffix == 0)
                suffix = 1;
            prefix *= nums[i];
            suffix *= nums[nums.length - i - 1];
            max = Integer.max(max, Integer.max(prefix, suffix));
        }
        return max;
    }
}
