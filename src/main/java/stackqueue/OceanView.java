package stackqueue;

import java.util.Stack;

public class OceanView {
    public static void main(String[] args) {
        int[] arr = {4, 2, 3, 1};
        calculate(arr);
    }

    public static void calculate(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int n = arr.length - 1; n >= 0; n--) {
            if (stack.isEmpty() || (arr[n] > arr[stack.peek()])) {
                stack.push(n);
                //System.out.println(arr[n]);
            }
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
