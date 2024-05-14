package arrays;

//Link:
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        /*
        Since array is sorted we will use binary search
        First we will check if nums[mid] is equal to target then return mid
        else if we will check if left half is sorted
            and if target lies between left half then change end to mid-1
            else change start to mid+1
        else
            if target lies between right half then change start to mid+1
            else change end to mid-1
         */
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 3;
        System.out.println(search(nums, target));
    }

    private static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[start] <= nums[mid]) {
                if (nums[start] <= target && target <= nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }

            } else {
                if (nums[mid] <= target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
