package leetcode;

/**
 * https://leetcode.com/problems/minimum-score-triangulation-of-polygon/
 */
public class Problem1039 {
    public int minScoreTriangulation(int[] A) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1039 prob = new Problem1039();
        System.out.println(prob.minScoreTriangulation(new int[]{1, 2, 3})); // 6
        System.out.println(prob.minScoreTriangulation(new int[]{3, 7, 4, 5})); // 144
        System.out.println(prob.minScoreTriangulation(new int[]{1, 3, 1, 4, 1, 5})); // 13
        System.out.println(prob.minScoreTriangulation(new int[]{1, 3, 1, 4, 1, 5, 6})); // 43
        System.out.println(prob.minScoreTriangulation(new int[]{1, 3, 1, 4, 1, 5, 6, 8})); // 91
    }
}
