package leetcode75;

public class MergeStringsAlternately {
    public static void main(String[] args) {
        System.out.println(mergeAlternately("ab", "pqrs"));
    }

    public static String mergeAlternately(String word1, String word2) {
        int first = 0;
        int second = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (first < word1.length() && second < word2.length()) {
            stringBuilder.append(word1.charAt(first++));
            stringBuilder.append(word2.charAt(second++));
        }
        if (first < word1.length()) {
            stringBuilder.append(word1.substring(first));
        }
        if (second < word2.length()) {
            stringBuilder.append(word2.substring(second));
        }
        return stringBuilder.toString();
    }
}
