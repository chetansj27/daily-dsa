package stackqueue;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {

    }

    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int length = heights.length;
        int[] leftSmaller = new int[length];
        int[] rightSmaller = new int[length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty())
                leftSmaller[i] = 0;
            else
                leftSmaller[i] = stack.peek() + 1;
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            stack.pop();
        }
        for (int i = length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty())
                rightSmaller[i] = length - 1;
            else
                rightSmaller[i] = stack.peek() - 1;
            stack.push(i);
        }
        for (int i = 0; i < length; i++) {
            maxArea = Math.max(maxArea, heights[i] * (rightSmaller[i] - leftSmaller[i] + 1));
        }
        return maxArea;

    }
}

