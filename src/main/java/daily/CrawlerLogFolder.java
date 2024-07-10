package daily;

import java.util.Stack;

public class CrawlerLogFolder {
    public static void main(String[] args) {
        String[] logs = {"./", "../", "./"};
        System.out.println(minOperations(logs));
    }

    public static int minOperations(String[] logs) {
        int count = 0;
        for (String log : logs) {
            if ("../".equals(log))
                count = Math.max(0, --count);
            else if (!"./".equals(log))
                count++;
        }
        return count;
        /*
         * Stack<String> stack = new Stack<>();
         * for (String log : logs) {
         * if ("../".equals(log)) {
         * if (!stack.isEmpty())
         * stack.pop();
         * } else if ("./".equals(log)) {
         * } else {
         * stack.push(log);
         * }
         * }
         * return stack.size();
         */
    }
}
