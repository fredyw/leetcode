package leetcode;

/**
 * https://leetcode.com/problems/dice-roll-simulation/
 */
public class Problem1223 {
    public int dieSimulator(int n, int[] rollMax) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1223 prob = new Problem1223();
        System.out.println(prob.dieSimulator(2, new int[]{1,1,2,2,2,3})); // 34
        System.out.println(prob.dieSimulator(2, new int[]{1,1,1,1,1,1})); // 30
        System.out.println(prob.dieSimulator(3, new int[]{1,1,1,2,2,3})); // 181
    }
}
