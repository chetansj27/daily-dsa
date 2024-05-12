package arrays;

import java.util.Arrays;

//Link - https://leetcode.com/problems/plus-one
public class PlusOne {
    public static void main(String[] args) {
        /*
            Approach
            if last digit is less than nine then just add 1 to last index number and return. Only one traversal
            if last digit is greater than nine then make that index 0 and continue the loop
            if array have only nines then create new array with one extra length and make 0th index as one
            Time complexity: O(n)
         */
        int[] arr = {1, 2, 3, 4, 9};
        System.out.println(Arrays.toString(plusOne(arr)));
    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}
