package leetcode;

/**
 * https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
 */
public class Problem1007 {
    public int minDominoRotations(int[] A, int[] B) {
        int[] aCounts = new int[6];
        int[] bCOunts = new int[6];
        for (int i = 0; i < A.length; i++) {
            aCounts[A[i] - 1]++;
            bCOunts[B[i] - 1]++;
        }
        int max = 0;
        boolean a = true;
        int val = 0;
        for (int i = 0; i < aCounts.length; i++) {
            if (aCounts[i] > max) {
                max = aCounts[i];
                val = i + 1;
                a = true;
            }
            if (bCOunts[i] > max) {
                max = bCOunts[i];
                val = i + 1;
                a = false;
            }
        }
        int answer = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == val && a || B[i] == val && !a) {
                continue;
            }
            if (A[i] == val || B[i] == val) {
                answer++;
            } else {
                return -1;
            }
        }
        return answer;
    }
}
