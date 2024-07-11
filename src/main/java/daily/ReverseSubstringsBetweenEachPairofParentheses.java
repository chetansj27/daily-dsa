package daily;

import java.util.Stack;

public class ReverseSubstringsBetweenEachPairofParentheses {
    public static void main(String[] args) {
        String s = "(ed(et(oc))el)";
        System.out.println(reverseParentheses(s));
    }

    public static String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                char c = stack.pop();
                StringBuilder stringBuilder = new StringBuilder();
                while (c != '(') {
                    stringBuilder.append(c);
                    c = stack.pop();
                }
                for (int j = 0; j < stringBuilder.length(); j++) {
                    stack.push(stringBuilder.charAt(j));
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }
}
