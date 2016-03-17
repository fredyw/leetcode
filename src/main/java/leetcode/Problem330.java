package leetcode;

/**
 * https://leetcode.com/problems/patching-array/
 */
public class Problem330 {
    public int minPatches(int[] nums, int n) {
        long sum = 0;
        int nPatch = 0;
        int index = 0;
        while (sum < n) {
            long patch = sum + 1;
            if (index >= nums.length || patch < nums[index]) {
                nPatch++;
                sum += patch;
            } else {
                sum += nums[index];
                index++;
            }
        }
        return nPatch;
    }
}
