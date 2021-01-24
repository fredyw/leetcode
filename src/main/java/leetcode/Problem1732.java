package leetcode;

/**
 * https://leetcode.com/problems/find-the-highest-altitude/
 */
public class Problem1732 {
    public int largestAltitude(int[] gain) {
        int answer = 0;
        int altitude = 0;
        for (int g : gain) {
            altitude += g;
            answer = Math.max(answer, altitude);
        }
        return answer;
    }
}
