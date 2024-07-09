package daily;

public class AverageWaitingTime {
    public static void main(String[] args) {
        int[][] customers = {
                {1, 2},
                {2, 5},
                {4, 3}
        };
        System.out.println(averageWaitingTime(customers));
    }

    public static double averageWaitingTime(int[][] customers) {
        int startTime = 0;
        double total = 0d;
        for (int[] customer : customers) {
            int inTime = customer[0];
            int prepareTime = customer[1];
            startTime = Math.max(startTime, inTime);
            total += (startTime - inTime) + prepareTime;
            startTime += prepareTime;
        }
        return total / customers.length;
    }
}
