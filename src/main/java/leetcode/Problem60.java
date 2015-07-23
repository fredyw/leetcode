package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/permutation-sequence/
 */
public class Problem60 {
    public String getPermutation(int n, int k) {
        int f = factorial(n);
        int segment = f / n;
        int idx = k / segment;
        if (k % segment != 0) {
            idx++;
        }
        IntRef intRef = new IntRef();
        intRef.k = (idx-1) * segment;
        Set<Integer> set = new HashSet<>();
        set.add(idx);
        return getPermutation(n, k, n-1, intRef, set, "" + idx);
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
    
    private int factorial(int n) {
        if (n == 1) {
            return n;
        }
        return n * factorial(n-1);
    }
    
    public static void main(String[] args) {
        Problem60 prob = new Problem60();
//        for (int i = 1 ; i <= 9; i++) {
//            System.out.println(prob.getPermutation(i, 1));
//        }
//        for (int i = 1 ; i <= 6; i++) {
//            System.out.println(prob.getPermutation(3, i));
//        }
        long start = System.currentTimeMillis();
        System.out.println(prob.getPermutation(8, 33856));
        System.out.println(prob.getPermutation(9, 94626));
        System.out.println(System.currentTimeMillis() - start);
    }
}
