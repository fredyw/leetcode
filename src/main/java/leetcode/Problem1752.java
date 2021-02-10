package leetcode;

/**
 * https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/
 */
public class Problem1752 {
    public boolean check(int[] nums) {
        int min = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                min = nums[i];
            } else {
                if (nums[i] < min) {
                    index = i;
                    min = nums[i];
                }
            }
        }
        int start = index - 1 % nums.length;
        start = start < 0 ? start + nums.length : start;
        while (nums[start] == nums[index] && start != index) {
            start = (start - 1) % nums.length;
            start = start < 0 ? start + nums.length : start;
        }
        int current = (start + 1) % nums.length;
        int next = (current + 1) % nums.length;
        while (next != (start + 1) % nums.length) {
            if (nums[current] > nums[next]) {
                return false;
            }
            current = (current + 1) % nums.length;
            next = (next + 1) % nums.length;
        }
        return true;
    }
}
