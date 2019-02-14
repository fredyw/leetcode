package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/binary-trees-with-factors/
 */
public class Problem823 {
    public int numFactoredBinaryTrees(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int a : A) {
            set.add(a);
        }
        long answer = 0;
        Map<Integer, Long> memo = new HashMap<>();
        for (int i : set) {
            answer += numFactoredBinaryTrees(set, i, memo) % (1e9 + 7);
        }
        return (int) (answer);
    }

    private static long numFactoredBinaryTrees(Set<Integer> set, int root,
                                               Map<Integer, Long> memo) {
        if (memo.containsKey(root)) {
            return memo.get(root);
        }
        long count = 1;
        for (int i : set) {
            if (root % i == 0) {
                int j = root / i;
                if (set.contains(j)) {
                    long a = numFactoredBinaryTrees(set, i, memo);
                    long b = numFactoredBinaryTrees(set, j, memo);
                    count += (a * b) % (1e9 + 7);
                }
            }
        }
        memo.put(root, count);
        return count;
    }
}
