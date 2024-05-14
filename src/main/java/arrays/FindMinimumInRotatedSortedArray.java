package arrays;

//Link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        /*
        Since array is sorted we will use binary search
        First we will check if nums[mid] is less than min then assign it to min
        else if we will check if left half is sorted and nums[start] is less than min then assign it to min
        else we will check if nums[start] is less than min then assign it to min
         */
        int[] nums = {3, 1, 2};
        System.out.println(findMinimum(nums));
    }

    private static int findMinimum(int[] nums) {
        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] < min) {
                min = nums[mid];
            } else if (nums[start] <= nums[mid]) {
                if (nums[start] < min) {
                    min = nums[start];
                }
                start = mid + 1;
            } else {
                if (nums[start] < min) {
                    min = nums[start];
                }
                end = mid - 1;
            }
        }
        return min;
    }
}
