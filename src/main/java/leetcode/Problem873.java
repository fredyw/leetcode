package leetcode;

/**
 * https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/
 */
public class Problem873 {
    public int lenLongestFibSubseq(int[] A) {
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                max = Math.max(max, lenLongestFibSubseq(A, i, j) + 2);
            }
        }
        return max;
    }

    private int lenLongestFibSubseq(int[] a, int i, int j) {
        int sum = a[i] + a[j];
        int x = j + 1;
        while (x < a.length && a[x] <= sum) {
            if (a[x] == sum) {
                return lenLongestFibSubseq(a, j, x) + 1;
            }
            x++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Problem873 prob = new Problem873();
        System.out.println(prob.lenLongestFibSubseq(new int[]{1, 2, 3, 4, 5, 6, 7, 8})); // 5
        System.out.println(prob.lenLongestFibSubseq(new int[]{1, 3, 7, 11, 12, 14, 18})); // 3
    }
}
