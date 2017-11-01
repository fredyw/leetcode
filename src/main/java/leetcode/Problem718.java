package leetcode;

/**
 * https://leetcode.com/problems/maximum-length-of-repeated-subarray/
 */
public class Problem718 {
    public int findLength(int[] A, int[] B) {
        return findLength(A, B, 0, 0);
    }

    private static int findLength(int[] a, int[] b, int i, int j) {
        if (i == a.length) {
            return 0;
        }
        if (j == b.length) {
            return 0;
        }
        int max = 0;
        if (a[i] == b[j]) {
            int z = findLength(a, b, i + 1, j + 1) + 1;
            max = Math.max(max, z);
        } else {
            int x = findLength(a, b, i, j + 1);
            int y = findLength(a, b, i + 1, j);
            max = Math.max(max, Math.max(x, y));
        }
        return max;
    }

    public static void main(String[] args) {
        Problem718 prob = new Problem718();
        System.out.println(prob.findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7})); // 3
        System.out.println(prob.findLength(new int[]{1, 2, 3, 2, 1}, new int[]{1, 3, 2, 1, 4, 7})); // 3
    }
}
