package stackqueue;

import java.util.Objects;
import java.util.Stack;

public class ReversePolishNotation {
    public static void main(String[] args) {
        String[] tokens = {"4", "13", "5", "/", "+"};
        System.out.println(calculate(tokens));

    }

    private static int calculate(String[] tokens) {
        Stack<Integer> res = new Stack<>();
        for (String current : tokens) {
            if ("+".equals(current)) {
                int val1 = res.pop();
                int val2 = res.pop();
                res.push(val1 + val2);
            } else if ("-".equals(current)) {
                int val1 = res.pop();
                int val2 = res.pop();
                res.push(val2 - val1);
            } else if ("*".equals(current)) {
                int val1 = res.pop();
                int val2 = res.pop();
                res.push(val1 * val2);
            } else if ("/".equals(current)) {
                int val1 = res.pop();
                int val2 = res.pop();
                res.push(val2 / val1);
            } else {
                res.push(Integer.valueOf(current));
            }
        }
        return res.pop();
    }
}
