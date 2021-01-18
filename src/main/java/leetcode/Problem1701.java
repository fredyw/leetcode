package leetcode;

/**
 * https://leetcode.com/problems/average-waiting-time/
 */
public class Problem1701 {
    public double averageWaitingTime(int[][] customers) {
        double answer = 0;
        int currentTime = customers[0][0];
        for (int i = 0; i < customers.length; i++) {
            int arrival = customers[i][0];
            int time = customers[i][1];
            if (arrival > currentTime) {
                currentTime = arrival + time;
            } else {
                currentTime += time;
            }
            answer += currentTime - arrival;
        }
        return answer / customers.length;
    }
}

