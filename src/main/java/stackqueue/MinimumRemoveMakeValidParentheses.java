package stackqueue;

import java.util.Stack;

public class MinimumRemoveMakeValidParentheses {
    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("))(("));
        System.out.println(minRemoveToMakeValidWithoutStack("))(("));
    }

    private static String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == '(') {
                stack.push(i);
            } else if (current == ')') {
                if (!stack.empty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                } else {
                    stack.push(i);
                }
            }
        }
        if (!stack.empty()) {
            while (!stack.empty()) {
                sb.deleteCharAt(stack.pop());
            }
        }
        return sb.toString();
    }

    private static String minRemoveToMakeValidWithoutStack(String s) {
        int open = 0;
        char[] characters = s.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            char current = characters[i];
            if (current == '(') {
                open++;
            } else if (current == ')') {
                if (open != 0) {
                    open--;
                } else {
                    characters[i] = '#';
                }
            }
        }
        for (int i = characters.length - 1; i >= 0; i--) {
            if (open > 0 && characters[i] == '(') {
                characters[i] = '#';
                open--;
            }
        }

        int p = 0;
        for (int i = 0; i < characters.length; i++) {
            if (characters[i] != '#')
                characters[p++] = characters[i];
        }

        return  new String(characters).substring(0, p);
    }
}
