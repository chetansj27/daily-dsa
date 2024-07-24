package greedy;

import java.util.Arrays;

public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int child = 0, cookie = 0;
        int n = g.length;
        int m = s.length;
        while (child < n && cookie < m) {
            if (g[child] <= s[cookie]) {
                child++;
            }
            cookie++;
        }
        return child;
    }
}
