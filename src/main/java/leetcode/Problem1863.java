package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/sum-of-all-subset-xor-totals/
 */
public class Problem1863 {
    public int subsetXORSum(int[] nums) {
        IntRef ref = new IntRef();
        subSetXORSum(nums, 0, new ArrayList<>(), ref);
        return ref.val;
    }

    private static class IntRef {
        private int val;
    }

    private static void subSetXORSum(int[] nums, int index, List<Integer> subset, IntRef ref) {
        if (!subset.isEmpty()) {
            int xor = subset.get(0);
            for (int i = 1; i < subset.size(); i++) {
                xor ^= subset.get(i);
            }
            ref.val += xor;
        }
        for (int i = index; i < nums.length; i++) {
            subset.add(nums[i]);
            subSetXORSum(nums, i + 1, subset, ref);
            subset.remove(subset.size() - 1);
        }
    }
}
