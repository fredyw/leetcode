package leetcode;

/**
 * https://leetcode.com/problems/search-a-2d-matrix/
 */
public class Problem74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        return false;
    }
    
    public static void main(String[] args) {
        Problem74 prob = new Problem74();
        int[][] matrix = new int[][] {
            new int[]{1,   3,  5,  7},
            new int[]{10, 11, 16, 20},
            new int[]{23, 30, 34, 50}
        };
        System.out.println(prob.searchMatrix(matrix, 3));
    }
}
