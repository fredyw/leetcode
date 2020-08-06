package leetcode;

/**
 * https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/
 */
public class Problem1509 {
    public int minDifference(int[] nums) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1509 prob = new Problem1509();
        System.out.println(prob.minDifference(new int[]{5,3,2,4})); // 0
        System.out.println(prob.minDifference(new int[]{1,5,0,10,14})); // 1
        System.out.println(prob.minDifference(new int[]{6,6,0,1,1,4,6})); // 2
        System.out.println(prob.minDifference(new int[]{1,5,6,14,15})); // 1
    }
}
