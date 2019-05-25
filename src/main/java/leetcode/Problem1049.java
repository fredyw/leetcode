package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/last-stone-weight-ii/
 */
public class Problem1049 {
    public int lastStoneWeightII(int[] stones) {
        int answer = Integer.MAX_VALUE;
        Set<Integer> indexes = new HashSet<>();
        for (int i = 0; i < stones.length; i++) {
            indexes.add(i);
            answer = Math.min(answer, lastStoneWeight(stones, i, indexes, 0));
            indexes.remove(i);
        }
        return answer;
    }

    private static int lastStoneWeight(int[] stones, int index, Set<Integer> indexes,
                                       int result) {
        if (indexes.size() == stones.length) {
            return result;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < stones.length; i++) {
            if (indexes.contains(i)) {
                continue;
            }
            indexes.add(i);
            int val = Math.max(stones[index], stones[i]) - Math.min(stones[index], stones[i]);
            if (val > 0) {
                // TODO:
            }
            min = Math.min(min, lastStoneWeight(stones, i, indexes, val));
            indexes.remove(i);
        }
        return min;
    }

    public static void main(String[] args) {
        Problem1049 prob = new Problem1049();
        System.out.println(prob.lastStoneWeightII(new int[]{2, 7, 4, 1, 8, 1})); // 1
    }
}
