package leetcode;

/**
 * https://leetcode.com/problems/rotate-array/
 */
public class Problem189 {
    public void rotate(int[] nums, int k) {
        if (nums.length <= 1) {
            return;
        }
        if (k >= nums.length) {
            k = k - nums.length;
        }
        int length = nums.length - k;
        int[] tmp = new int[length];
        int i = 0;
        for (; i < length; i++) {
            tmp[i] = nums[i];
        }
        int j = 0;
        for (; i < nums.length; i++) {
            int t = nums[j];
            nums[j] = nums[i];
            nums[i] = t;
            j++;
        }
        for (int z = 0; z < tmp.length; z++) {
            nums[j++] = tmp[z];
        }
    }
}
