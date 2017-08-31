package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/beautiful-arrangement-ii/
 */
public class Problem667 {
    public int[] constructArray(int n, int k) {
        int[] result = new int[n];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                result[idx++] = i + 1;
                continue;
            }
            if (k > 0) {
                int a = result[i - 1] - k;
                if (a <= 0) {
                    a = result[i - 1] + k;
                }
                result[idx++] = a;
                k--;
            } else {
                result[idx++] = result[i - 1] + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Problem667 prob = new Problem667();
        System.out.println(Arrays.toString(prob.constructArray(3, 1))); // [1,2,3]
        System.out.println(Arrays.toString(prob.constructArray(3, 2))); // [1,3,2]
        System.out.println(Arrays.toString(prob.constructArray(10, 9))); // [1,10,2,9,3,8,4,7,5,6]
        System.out.println(Arrays.toString(prob.constructArray(10, 5))); // [1,6,2,5,3,4,7,8,9,10]
    }
}
