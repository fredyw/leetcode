package leetcode;

/**
 * https://leetcode.com/problems/slowest-key/
 */
public class Problem1629 {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char answer = ' ';
        int max = 0;
        for (int i = 0; i < releaseTimes.length; i++) {
            if (i == 0) {
                max = releaseTimes[i];
                answer = keysPressed.charAt(i);
            } else {
                int diff = releaseTimes[i] - releaseTimes[i - 1];
                char c = keysPressed.charAt(i);
                if (diff > max || (diff == max && c > answer)) {
                    max = diff;
                    answer = c;
                }
            }
        }
        return answer;
    }
}
