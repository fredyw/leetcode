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
            answer += (numFactoredBinaryTrees(set, i, memo) + 1) % (1e9 + 7);
        }
        return (int) (answer % (1e9 + 7));
    }

    private static long numFactoredBinaryTrees(Set<Integer> set, int root,
                                               Map<Integer, Long> memo) {
        if (memo.containsKey(root)) {
            return memo.get(root);
        }
        long count = 0;
        for (int i : set) {
            if (root % i == 0) {
                int j = root / i;
                if (set.contains(j)) {
                    long a = numFactoredBinaryTrees(set, i, memo);
                    long b = numFactoredBinaryTrees(set, j, memo);
                    count += (a + b + 1) % (1e9 + 7);
                }
            }
        }
        memo.put(root, count);
        return count;
    }

    public static void main(String[] args) {
        Problem823 prob = new Problem823();
        System.out.println(prob.numFactoredBinaryTrees(new int[]{2, 4})); // 3
        System.out.println(prob.numFactoredBinaryTrees(new int[]{2, 4, 5, 10})); // 7
        System.out.println(prob.numFactoredBinaryTrees(new int[]{2346, 409, 1428, 1392, 1233, 18, 1215, 1159, 556, 2371, 1620, 1045, 1993, 2131, 1650, 1268, 703, 1725, 1402, 1178, 1258, 1861, 1688, 674, 202, 576, 2320, 530, 2002, 1519, 1138, 891, 1474, 1020, 1440, 1540, 1513, 669, 360, 1452, 63, 1893, 1785, 1572, 1240, 1222, 2398, 679, 1414, 1220})); // 50
        System.out.println(prob.numFactoredBinaryTrees(new int[]{45, 42, 2, 18, 23, 1170, 12, 41, 40, 9, 47, 24, 33, 28, 10, 32, 29, 17, 46, 11, 759, 37, 6, 26, 21, 49, 31, 14, 19, 8, 13, 7, 27, 22, 3, 36, 34, 38, 39, 30, 43, 15, 4, 16, 35, 25, 20, 44, 5, 48})); // 777
    }
}
