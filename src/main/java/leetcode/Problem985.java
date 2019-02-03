package leetcode;

/**
 * https://leetcode.com/problems/sum-of-even-numbers-after-queries/
 */
public class Problem985 {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem985 prob = new Problem985();
        System.out.println(prob.sumEvenAfterQueries(new int[]{1, 2, 3, 4}, new int[][]{
            {1, 0}, {-3, 1}, {-4, 0}, {2, 3}
        })); // [8,6,2,4]
    }
}
