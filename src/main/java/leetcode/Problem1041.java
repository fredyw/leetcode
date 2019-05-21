package leetcode;

/**
 * https://leetcode.com/problems/robot-bounded-in-circle/
 */
public class Problem1041 {
    public boolean isRobotBounded(String instructions) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem1041 prob = new Problem1041();
        System.out.println(prob.isRobotBounded("GGLLGG")); // true
        System.out.println(prob.isRobotBounded("GG")); // false
        System.out.println(prob.isRobotBounded("GL")); // true
    }
}
