package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/bitwise-ors-of-subarrays/
 */
public class Problem898 {
    public int subarrayBitwiseORs(int[] A) {
        Set<Integer> answer = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            Set<Integer> tmp = new HashSet<>();
            tmp.add(A[i]);
            for (int a : set) {
                tmp.add(A[i] | a);
            }
            answer.addAll(tmp);
            set = tmp;
        }
        return answer.size();
    }
}
