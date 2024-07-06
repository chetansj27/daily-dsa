package daily;

import linkedlist.ListNode;

public class PassThePillow {
    public static void main(String[] args) {
        System.out.println(passThePillow(4, 5));
    }

    public static int passThePillow(int n, int time) {
        int current = 1;
        int dir = 1;
        for (int i = 0; i < time; i++) {
            if (n == current) {
                dir = -1;
            }
            if (current == 1) {
                dir = 1;
            }
            if (dir < 0) {
                current--;
            } else {
                current++;
            }
        }
        return current;
    }
}
