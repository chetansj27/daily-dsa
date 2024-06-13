package stackqueue;

import java.util.Stack;

public class MaximumNestingDepthOfTheParentheses {
    public static void main(String[] args) {
        System.out.println(maxDepth("(1+(2*3)+((8)/4))+"));
        System.out.println(maxDepthWithoutStack("(1+(2*3)+((8)/4))+"));
    }

    private static int maxDepth(String s) {
        Stack<Character> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == '(') {
                stack.push(current);
                if (stack.size() > max) {
                    max = stack.size();
                }
            } else if (current == ')' && !stack.empty()) {
                stack.pop();
            }
        }
        return max;
    }

    private static int maxDepthWithoutStack(String s) {
        int count = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == '(') {
                max = Integer.max(max, ++count);
            } else if (current == ')') {
                count--;
            }
        }
        return max;
    }
}
