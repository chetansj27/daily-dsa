package stackqueue;

import java.util.LinkedList;
import java.util.Queue;

public class TimeNeededToBuyTickets {
    public static void main(String[] args) {
        int[] tickets = {5, 1, 1, 1};
        int k = 0;
        System.out.println(timeRequiredToBuy(tickets, k));
        int[] tickets2 = {5, 1, 1, 1};
        System.out.println(timeRequiredToBuyWithoutQueue(tickets2, k));
    }

    public static int timeRequiredToBuy(int[] tickets, int k) {
        int res = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < tickets.length; i++) {
            queue.add(i);
        }
        while (tickets[k] != 0) {
            if (tickets[queue.peek()] == 0) {
                queue.remove();
            } else {
                tickets[queue.peek()]--;
                queue.add(queue.remove());
                res++;
            }

        }
        return res;

    }

    public static int timeRequiredToBuyWithoutQueue(int[] tickets, int k) {
        int res = 0;
        for (int i = 0; i < tickets.length; i++) {
            if (i <= k) {
                res += Math.min(tickets[i], tickets[k]);
            } else {
                res += Math.min(tickets[i], (tickets[k] - 1));
            }
        }
        return res;

    }

}
