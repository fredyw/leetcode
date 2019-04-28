package leetcode;

/**
 * https://leetcode.com/problems/uncrossed-lines/
 */
public class Problem1035 {
    public int maxUncrossedLines(int[] A, int[] B) {
        int answer = 0;
        for (int i = 0; i < A.length; i++) {
            answer = Math.max(answer, maxUncrossedLines(A, B, i, 0));
        }
        return answer;
    }

    private static int maxUncrossedLines(int[] a, int[] b, int i, int j) {
        if (i == a.length || j == b.length) {
            return 0;
        }
        int max = 0;
        if (a[i] == b[j]) {
            max = Math.max(max, maxUncrossedLines(a, b, i + 1, j + 1) + 1);
        }
        max = Math.max(max, maxUncrossedLines(a, b, i, j + 1));
        return max;
    }

    public static void main(String[] args) {
        Problem1035 prob = new Problem1035();
        System.out.println(prob.maxUncrossedLines(new int[]{1, 4, 2}, new int[]{1, 2, 4})); // 2
        System.out.println(prob.maxUncrossedLines(new int[]{2, 5, 1, 2, 5}, new int[]{10, 5, 2, 1, 5, 2})); // 3
        System.out.println(prob.maxUncrossedLines(new int[]{2, 5, 1, 2, 5, 8}, new int[]{10, 5, 2, 1, 5, 2, 8})); // 4
        System.out.println(prob.maxUncrossedLines(new int[]{1, 3, 7, 1, 7, 5}, new int[]{1, 9, 2, 5, 1})); // 2
    }
}
