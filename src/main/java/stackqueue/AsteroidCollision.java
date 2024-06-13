package stackqueue;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
        int[] asteroids = {5, 10, -5};
        System.out.println(Arrays.toString(asteroidCollision(asteroids)));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                int diff = asteroid + stack.peek();
                if (diff < 0) {
                    stack.pop();
                } else if (diff > 0) {
                    asteroid = 0;
                } else {
                    asteroid = 0;
                    stack.pop();
                }
            }
            if (asteroid != 0) {
                stack.push(asteroid);
            }
        }
        int[] res = new int[stack.size()];
        for (int n = res.length - 1; n >= 0; n--) {
            res[n] = stack.pop();
        }
        return res;

    }
}
