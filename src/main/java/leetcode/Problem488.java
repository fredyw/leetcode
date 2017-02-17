package leetcode;

/**
 * https://leetcode.com/problems/zuma-game/
 */
public class Problem488 {
    public int findMinStep(String board, String hand) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem488 prob = new Problem488();
        System.out.println(prob.findMinStep("WRRBBW", "RB")); // -1
        System.out.println(prob.findMinStep("WWRRBBWW", "WRBRW")); // 2
        System.out.println(prob.findMinStep("G", "GGGGG")); // 2
        System.out.println(prob.findMinStep("RBYYBBRRB", "YRBGB")); // 3
    }
}
