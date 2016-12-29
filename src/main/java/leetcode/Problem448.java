package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 */
public class Problem448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                int to = nums[i] - 1;
                swap(nums, to);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                result.add(i + 1);
            }
        }
        return result;
    }

    private static void swap(int[] nums, int from) {
        if (nums[from] == from + 1) {
            return;
        }
        int val = nums[from];
        nums[from] = from + 1;
        swap(nums, val - 1);
    }
}
