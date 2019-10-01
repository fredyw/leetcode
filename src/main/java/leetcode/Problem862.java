package leetcode;

/**
 * https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/
 */
public class Problem862 {
    public int shortestSubarray(int[] A, int K) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem862 prob = new Problem862();
        System.out.println(prob.shortestSubarray(new int[]{1}, 1)); // 1
        System.out.println(prob.shortestSubarray(new int[]{1, 2}, 4)); // -1
        System.out.println(prob.shortestSubarray(new int[]{2, -1, 2}, 3)); // 3
    }
}
