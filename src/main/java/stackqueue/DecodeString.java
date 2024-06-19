package stackqueue;

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        decodeString("100[leetcode]");

    }

    public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> output = new Stack<>();
        int k = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = (k * 10) + (c - '0');
            } else if (c == '[') {
                countStack.push(k);
                k = 0;
                output.push(String.valueOf(c));
            } else if (c != ']') {
                output.push(String.valueOf(c));
            } else {
                StringBuilder tempString = new StringBuilder();
                while (!output.peek().equals("[")) {
                    tempString.insert(0, output.pop());
                }
                output.pop();
                int times = countStack.pop();
                StringBuilder res = new StringBuilder();
                while (times != 0) {
                    res.append(tempString);
                    times--;
                }
                output.push(res.toString());
            }
        }
        StringBuilder result = new StringBuilder();
        while (!output.isEmpty()) {
            result.insert(0, output.pop());
        }
        return result.toString();
    }
}
