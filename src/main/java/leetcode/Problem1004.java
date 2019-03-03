package leetcode;

/**
 * https://leetcode.com/problems/max-consecutive-ones-iii/
 */
public class Problem1004 {
    public int longestOnes(int[] A, int K) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1004 prob = new Problem1004();
        System.out.println(prob.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2)); // 6
        System.out.println(prob.longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3)); // 10
    }
}
