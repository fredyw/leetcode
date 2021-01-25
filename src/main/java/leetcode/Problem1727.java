package leetcode;

/**
 * https://leetcode.com/problems/largest-submatrix-with-rearrangements/
 */
public class Problem1727 {
    public int largestSubmatrix(int[][] matrix) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1727 prob = new Problem1727();
        System.out.println(prob.largestSubmatrix(new int[][]{
            {0,0,1},{1,1,1},{1,0,1}
        })); // 4
        System.out.println(prob.largestSubmatrix(new int[][]{
            {1,0,1,0,1}
        })); // 3
        System.out.println(prob.largestSubmatrix(new int[][]{
            {1,1,0},{1,0,1}
        })); // 2
        System.out.println(prob.largestSubmatrix(new int[][]{
            {0,0},{0,0}
        })); // 0
    }
}
