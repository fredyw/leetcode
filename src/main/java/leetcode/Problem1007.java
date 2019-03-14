package leetcode;

/**
 * https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
 */
public class Problem1007 {
    public int minDominoRotations(int[] A, int[] B) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1007 prob = new Problem1007();
        System.out.println(prob.minDominoRotations(new int[]{2, 1, 2, 4, 2, 2}, new int[]{5, 2, 6, 2, 3, 2})); // 2
        System.out.println(prob.minDominoRotations(new int[]{3, 5, 1, 2, 3}, new int[]{3, 6, 3, 3, 4})); // -1
    }
}
