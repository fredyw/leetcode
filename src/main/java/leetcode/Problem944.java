package leetcode;

/**
 * https://leetcode.com/problems/delete-columns-to-make-sorted/
 */
public class Problem944 {
    public int minDeletionSize(String[] A) {
        int maxRow = A.length;
        int maxCol = A.length > 0 ? A[0].length() : 0;
        int count = 0;
        for (int col = 0; col < maxCol; col++) {
            for (int row = 1; row < maxRow; row++) {
                if (A[row - 1].charAt(col) > A[row].charAt(col)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
