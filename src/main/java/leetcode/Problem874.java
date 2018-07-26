package leetcode;

/**
 * https://leetcode.com/problems/walking-robot-simulation/
 */
public class Problem874 {
    public int robotSim(int[] commands, int[][] obstacles) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem874 prob = new Problem874();
        System.out.println(prob.robotSim(new int[]{4, -1, 3}, new int[][]{})); // 25
        System.out.println(prob.robotSim(new int[]{4, -1, 4, -2, 4}, new int[][]{
            {2, 4}
        })); // 65
    }
}
