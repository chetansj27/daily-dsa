package arrays;

public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = {2, 1};
        System.out.println(findNumber(nums));
    }

    public static int findNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= nums.length && nums[i] > 0) {
                nums[nums[i] - 1] = nums[i];
            }
        }
        int missing = nums.length + 1;
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] != i) {
                missing = i;
                break;
            }
        }
        return missing;
    }
}
