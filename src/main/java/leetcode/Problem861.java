package leetcode;

/**
 * https://leetcode.com/problems/score-after-flipping-matrix/
 */
public class Problem861 {
    public int matrixScore(int[][] A) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem861 prob = new Problem861();
//            {1, 1, 1, 1},
//            {1, 0, 0, 1},
//            {1, 1, 1, 1}
        System.out.println(prob.matrixScore(new int[][]{
            {0, 0, 1, 1},
            {1, 0, 1, 0},
            {1, 1, 0, 0}
        })); // 39
    }
}
