package leetcode;

/**
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 */
public class Problem240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        return false;
    }
    
    public static void main(String[] args) {
        Problem240 prob = new Problem240();
        int[][] matrix = new int[][] {
            new int[]{ 1,  4,  7, 11, 15},
            new int[]{ 2,  5,  8, 12, 19},
            new int[]{ 3,  6,  9, 16, 22},
            new int[]{10, 13, 14, 17, 24},
            new int[]{18, 21, 23, 26, 30}
        };
        System.out.println(prob.searchMatrix(matrix, 5)); // true
        System.out.println(prob.searchMatrix(matrix, 20)); // false
    }
}
