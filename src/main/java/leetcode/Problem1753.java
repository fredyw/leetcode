package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-score-from-removing-stones/
 */
public class Problem1753 {
    public int maximumScore(int a, int b, int c) {
        int answer = 0;
        int[] array = new int[]{a, b, c};
        while (true) {
            // Find two maximum values in the array, but I'm lazy and the array has a
            // fixed size, which is 3.
            Arrays.sort(array);
            array[1]--;
            array[2]--;
            answer++;
            if ((array[0] <= 0 && array[1] <= 0) || (array[0] <= 0 && array[2] <= 0) ||
                (array[1] <= 0 && array[2] <= 0)) {
                break;
            }
        }
        return answer;
    }
}
