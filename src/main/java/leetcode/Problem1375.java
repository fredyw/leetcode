package leetcode;

/**
 * https://leetcode.com/problems/bulb-switcher-iii/
 */
public class Problem1375 {
    public int numTimesAllBlue(int[] light) {
        int answer = 0;
        int[] colors = new int[light.length]; // 0 = white, 1 = yellow, 2 = blue
        int yellowCount = 0;
        for (int l : light) {
            if (l - 2 >= 0 && colors[l - 2] == 2 && yellowCount == 0) {
                colors[l - 1] = 2;
                answer++;
                continue;
            } else {
                colors[l - 1] = 1;
                yellowCount++;
            }
            int i = 0;
            while (i < light.length && (colors[i] == 1 || colors[i] == 2)) {
                if (colors[i] == 1) {
                    yellowCount--;
                }
                colors[i] = 2;
                i++;
            }
            if (yellowCount == 0) {
                answer++;
            }
        }
        return answer;
    }
}
