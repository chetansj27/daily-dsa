package arrays;

public class FindtheNumberofGoodPairsI {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 4};
        int[] nums2 = {1, 3, 4};
        int k = 1;
        System.out.println(numberOfPairs(nums1, nums2, k));
    }

    private static int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int count = 0;
        for (int val1 : nums1) {
            for (int val2 : nums2) {
                if (val1 % (val2 * k) == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
