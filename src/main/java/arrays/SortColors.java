package arrays;

public class SortColors {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 1, 2, 0, 2, 1, 0};
        sortColors(nums);
    }

    public static void sortColors(int[] nums) {
        int red = 0;
        int white = 0;
        int blue = 0;

        for (int i : nums) {
            if (i == 0) red++;
            else if (i == 1) white++;
            else blue++;
        }
        for (int i = 0; i < red; i++) {
            nums[i] = 0;
        }
        for (int i = red; i < red + white; i++) {
            nums[i] = 1;
        }
        for (int i = red + white; i < red + white + blue; i++) {
            nums[i] = 2;
        }
    }
}
