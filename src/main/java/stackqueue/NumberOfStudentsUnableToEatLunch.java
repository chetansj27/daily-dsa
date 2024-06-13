package stackqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class NumberOfStudentsUnableToEatLunch {
    public static void main(String[] args) {
        int[] students = {1, 1, 1, 0, 0, 1};
        int[] sandwiches = {1, 0, 0, 0, 1, 1};
        System.out.println(countStudents(students, sandwiches));
        System.out.println(countStudentsWithoutQueue(students, sandwiches));
    }

    public static int countStudents(int[] students, int[] sandwiches) {
        Stack<Integer> sandwichesStack = new Stack<>();
        Queue<Integer> studentsQueue = new LinkedList<>();
        for (int i = sandwiches.length - 1; i >= 0; i--) {
            sandwichesStack.push(sandwiches[i]);
        }
        for (int j : students) {
            studentsQueue.add(j);
        }

        int counter = 0;
        while (!sandwichesStack.isEmpty()) {
            int student = studentsQueue.remove();
            if (sandwichesStack.peek() == student) {
                sandwichesStack.pop();
                counter = 0;
            } else {
                studentsQueue.add(student);
                counter++;
                if (counter == studentsQueue.size()) {
                    return counter;
                }
            }
        }

        return 0;
    }

    public static int countStudentsWithoutQueue(int[] students, int[] sandwiches) {
        int zeroCount = 0;
        int oneCount = 0;
        for (int i : students) {
            if (i == 0)
                zeroCount++;
            else
                oneCount++;
        }
        for (int i : sandwiches) {
            if (i == 0) {
                if (zeroCount == 0) {
                    return oneCount;
                }
                zeroCount--;
            } else {
                if (oneCount == 0) {
                    return zeroCount;
                }
                oneCount--;
            }
        }
        return 0;
    }

}
