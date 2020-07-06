package leetcode;

/**
 * https://leetcode.com/problems/count-submatrices-with-all-ones/
 */
public class Problem1504 {
    public int numSubmat(int[][] mat) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1504 prob = new Problem1504();
        System.out.println(prob.numSubmat(new int[][]{
            {1,0,1},
            {1,1,0},
            {1,1,0},
        })); // 13
        System.out.println(prob.numSubmat(new int[][]{
            {0,1,1,0},
            {0,1,1,1},
            {1,1,1,0},
        })); // 24
        System.out.println(prob.numSubmat(new int[][]{
            {1,1,1,1,1,1},
        })); // 21
        System.out.println(prob.numSubmat(new int[][]{
            {1,0,1},
            {0,1,0},
            {1,0,1},
        })); // 5
    }
}
