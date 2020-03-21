package leetcode;

/**
 * https://leetcode.com/problems/bulb-switcher-iii/
 */
public class Problem1375 {
    public int numTimesAllBlue(int[] light) {
        int answer = 0;
        Color[] colors = new Color[light.length];
        for (int i = 0; i < light.length; i++) {
            colors[i] = Color.WHITE;
        }
        int yellowCount = 0;
        for (int l : light) {
            colors[l - 1] = Color.YELLOW;
            yellowCount++;
            int i = 0;
            while (i < light.length && colors[i].on) {
                if (colors[i] == Color.YELLOW) {
                    yellowCount--;
                }
                colors[i] = Color.BLUE;
                i++;
            }
            if (yellowCount == 0) {
                answer++;
            }
        }
        return answer;
    }

    private enum Color {
        WHITE(false),
        YELLOW(true),
        BLUE(true);

        private final boolean on;

        Color(boolean on) {
            this.on = on;
        }
    }

    public static void main(String[] args) {
        Problem1375 prob = new Problem1375();
        System.out.println(prob.numTimesAllBlue(new int[]{2,1,3,5,4})); // 3
        System.out.println(prob.numTimesAllBlue(new int[]{3,2,4,1,5})); // 2
        System.out.println(prob.numTimesAllBlue(new int[]{4, 1, 2, 3})); // 1
        System.out.println(prob.numTimesAllBlue(new int[]{2,1,4,3,6,5})); // 3
        System.out.println(prob.numTimesAllBlue(new int[]{1,2,3,4,5,6})); // 6
        System.out.println(prob.numTimesAllBlue(new int[]{3,2,1})); // 1
        System.out.println(prob.numTimesAllBlue(new int[]{3,1,2})); // 1
    }
}
