package arrays;

public class FirstAndLastOccurrence {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int first = firstOccurrence(nums, 8);
        int last = lastOccurrence(nums, 8);
        System.out.println(first);
        System.out.println(last);
        System.out.println(new int[]{first, last});
    }

    private static int firstOccurrence(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int first = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                first = mid;
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return first;
    }

    private static int lastOccurrence(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int last = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                last = mid;
                low = mid + 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return last;
    }

}
