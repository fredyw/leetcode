package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/bitwise-ors-of-subarrays/
 */
public class Problem898 {
    public int subarrayBitwiseORs(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            int or = A[i];
            set.add(or);
            for (int j = i + 1; j < A.length; j++) {
                set.add(A[j]);
                or |= A[j];
                set.add(or);
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        Problem898 prob = new Problem898();
        System.out.println(prob.subarrayBitwiseORs(new int[]{0})); // 1
        System.out.println(prob.subarrayBitwiseORs(new int[]{1, 1, 2})); // 3
        System.out.println(prob.subarrayBitwiseORs(new int[]{1, 2, 4})); // 6
        System.out.println(prob.subarrayBitwiseORs(new int[]{1, 2, 4, 5})); // 7
    }
}
