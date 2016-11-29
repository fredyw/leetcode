package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
 */
public class Problem421 {
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        int mask = 0;
        for (int i = 31; i >= 0; i--) {
            mask |= (1 << i);
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num & mask);
            }
            int tmp = max | (1 << i);
            for (int num : set) {
                if (set.contains(num ^ tmp)) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }
}
