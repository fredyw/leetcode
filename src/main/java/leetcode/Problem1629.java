package leetcode;

/**
 * https://leetcode.com/problems/slowest-key/
 */
public class Problem1629 {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1629 prob = new Problem1629();
        System.out.println(prob.slowestKey(new int[]{9,29,49,50}, "cbcd")); // "c"
        System.out.println(prob.slowestKey(new int[]{12,23,36,46,62}, "spuda")); // "a"
    }
}
