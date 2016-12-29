package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/
 */
public class Problem442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                int to = nums[i] - 1;
                nums[i] = 0;
                int n = swap(nums, to);
                if (n != 0) {
                    result.add(n);
                }
            }
        }
        return result;
    }

    private static int swap(int[] nums, int from) {
        if (nums[from] == from + 1) {
            return nums[from];
        }
        int val = nums[from];
        nums[from] = from + 1;
        if (val == 0) {
            return 0;
        }
        return swap(nums, val - 1);
    }
}
