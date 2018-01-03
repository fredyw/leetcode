package leetcode;

/**
 * https://leetcode.com/problems/pour-water/
 */
public class Problem756 {
    public int[] pourWater(int[] heights, int V, int K) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem756 prob = new Problem756();
        System.out.println(prob.pourWater(new int[]{2, 1, 1, 2, 1, 2, 2}, 4, 3)); // [2,2,2,3,2,2,2]
        System.out.println(prob.pourWater(new int[]{1, 2, 3, 4}, 2, 2)); // [2,3,3,4]
        System.out.println(prob.pourWater(new int[]{3, 1, 3}, 5, 1)); // [4,4,4]
    }
}
