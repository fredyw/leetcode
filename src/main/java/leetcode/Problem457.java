package leetcode;

/**
 * https://leetcode.com/problems/circular-array-loop/
 */
public class Problem457 {
    public boolean circularArrayLoop(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            int val1 = nums[i];
            nums[i] = 0;
            int j = i + val1;
            j %= nums.length;
            if (j < 0) {
                j = nums.length + j;
            }
            int val2 = nums[j];
            boolean found = false;
            boolean skip = false;
            while (nums[j] != 0) {
                if (val1 < 0 != val2 < 0) {
                    skip = true;
                }
                nums[j] = 0;
                j += val2;
                j %= nums.length;
                if (j < 0) {
                    j = nums.length + j;
                }
                if (i == j && !skip) {
                    found = true;
                }
                val2 = nums[j];
            }
            if (found) {
                return true;
            }
        }
        return false;
    }
}
