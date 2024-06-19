package stackqueue;

import java.util.Stack;

public class ValidParenthesisString {
    public static void main(String[] args) {
        System.out.println(checkValidString("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"));
    }

    public static boolean checkValidString(String s) {
        int starCount = 0;
        int closeCount = 0;
        int openCount = 0;
        for (char c : s.toCharArray()) {
            if (c == '(')
                openCount++;
            else if (c == ')')
                closeCount++;
            else
                starCount++;
        }
        if (openCount == closeCount)
            return true;
        if (openCount - closeCount > 0) {
            return starCount >= openCount - closeCount;
        } else {
            return starCount >= closeCount - openCount;
        }
    }
}
