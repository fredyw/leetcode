package leetcode;

/**
 * https://leetcode.com/problems/non-decreasing-array/
 */
public class Problem665 {
    public boolean checkPossibility(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int prev = 0;
        int count = 0;
        for (int curr = 1; curr < nums.length; curr++) {
            if (nums[prev] > nums[curr]) {
                if (prev == 0) {
                    nums[prev] = nums[curr];
                } else {
                    if (nums[prev - 1] >= nums[curr]) {
                        nums[curr] = nums[prev];
                    } else {
                        nums[prev] = nums[curr];
                    }
                }
                count++;
                if (count == 2) {
                    return false;
                }
            }
            prev = curr;
        }
        return true;
    }
}
