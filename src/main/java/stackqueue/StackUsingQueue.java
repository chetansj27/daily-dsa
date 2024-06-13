package stackqueue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class StackUsingQueue {
    public static void main(String[] args) {

    }
}

class MyStack {
    Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        int size = queue.size();
        queue.add(x);
        for (int i = 0; i < size; i++) {
            queue.add(queue.remove());
        }
    }

    public int pop() {
        if (queue.isEmpty())
            return -1;
        return queue.remove();
    }

    public int top() {
        if (queue.isEmpty())
            return -1;
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
