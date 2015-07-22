package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/permutation-sequence/
 */
public class Problem60 {
    public String getPermutation(int n, int k) {
        return getPermutation(n, k, n, new IntRef(), new HashSet<>(), "");
    }
    
    private static class IntRef {
        int k;
    }
    
    private String getPermutation(int n, int k, int m, IntRef intRef, Set<Integer> set, String accu) {
        if (m == 0) {
            intRef.k++;
            if (intRef.k == k) {
                return accu;
            }
            return null;
        }
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                Set<Integer> newSet = new HashSet<>(set);
                newSet.add(i);
                String result = getPermutation(n, k, m-1, intRef, newSet, accu+i);
                if (result != null) {
                    return result;
                }
            }
        }
        return null;
    }
    
    public static void main(String[] args) {
        Problem60 prob = new Problem60();
        System.out.println(prob.getPermutation(9, 171669));
    }
}
