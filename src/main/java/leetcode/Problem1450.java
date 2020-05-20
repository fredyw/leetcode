package leetcode;

/**
 * https://leetcode.com/problems/number-of-students-doing-homework-at-a-given-time/
 */
public class Problem1450 {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int answer = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] <= queryTime && queryTime <= endTime[i]) {
                answer++;
            }
        }
        return answer;
    }
}
