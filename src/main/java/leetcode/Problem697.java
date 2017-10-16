package leetcode;

/**
 * https://leetcode.com/problems/degree-of-an-array/
 */
public class Problem697 {
    public int findShortestSubArray(int[] nums) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem697 prob = new Problem697();
        System.out.println(prob.findShortestSubArray(new int[]{1, 2, 2, 3, 1})); // 2
        System.out.println(prob.findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2})); // 6
        System.out.println(prob.findShortestSubArray(new int[]{1, 1, 1, 1, 1})); // 5
    }
}
