package leetcode;

/**
 * https://leetcode.com/problems/jump-game-iii/
 */
public class Problem1306 {
    public boolean canReach(int[] arr, int start) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem1306 prob = new Problem1306();
        System.out.println(prob.canReach(new int[]{4,2,3,0,3,1,2}, 5)); // true
        System.out.println(prob.canReach(new int[]{4,2,3,0,3,1,2}, 0)); // true
        System.out.println(prob.canReach(new int[]{3,0,2,1,2}, 2)); // false
    }
}
