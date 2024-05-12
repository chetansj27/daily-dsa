package arrays;

//Link - https://leetcode.com/problems/search-insert-position/
public class SearchInsertPosition {
    public static void main(String[] args) {
        /*
            Approach
            Use binary search
            If element exist then return its index
            If element not exist then return the index where element can be inserted (return value of start)
            Time complexity: O(log n)
         */
        int[] nums = {1, 3, 4, 6};
        int target = 5;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
