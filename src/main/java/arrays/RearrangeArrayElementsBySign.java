package arrays;
//Link

import java.util.Arrays;

public class RearrangeArrayElementsBySign {
    public static void main(String[] args) {
        int[] nums = {3, 1, -2, -5, 2, -4};
        System.out.println(Arrays.toString(rearrange(nums)));
    }

    private static int[] rearrange(int[] nums) {
        int positiveCount = 0;
        int negativeCount = 0;
        int[] output = new int[nums.length];
        for (int num : nums) {
            if (num > 0) {
                output[positiveCount * 2] = num;
                positiveCount++;
            } else {
                output[negativeCount * 2 + 1] = num;
                negativeCount++;
            }
        }
        return output;
    }
}
