package leetcode;

/**
 * https://leetcode.com/problems/image-overlap/
 */
public class Problem835 {
    public int largestOverlap(int[][] A, int[][] B) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem835 prob = new Problem835();
        System.out.println(prob.largestOverlap(new int[][]{
            {1, 1, 0},
            {0, 1, 0},
            {0, 1, 0}
        }, new int[][]{
            {0, 0, 0},
            {0, 1, 1},
            {0, 0, 1}
        })); // 3
    }
}
