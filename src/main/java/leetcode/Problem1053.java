package leetcode;

/**
 * https://leetcode.com/problems/previous-permutation-with-one-swap/
 */
public class Problem1053 {
    public int[] prevPermOpt1(int[] A) {
        for (int i = A.length - 1; i >= 0; i--) {
            int j = i + 1;
            int index = -1;
            while (j < A.length && A[i] > A[j]) {
                if (index == -1 || A[index] != A[j]) {
                    index = j;
                }
                j++;
            }
            if (index != -1) {
                int tmp = A[i];
                A[i] = A[index];
                A[index] = tmp;
                break;
            }
        }
        return A;
    }
}
