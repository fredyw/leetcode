package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/matchsticks-to-square/
 */
public class Problem473 {
    public boolean makesquare(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int length = sum / 4;
        int remainder = sum % 4;
        if (remainder != 0 || nums.length < 4) {
            return false;
        }
        Arrays.sort(nums);
        reverse(nums);
        return makeSquare(nums, 0, length, length, length, length);
    }

    private static void reverse(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++; j--;
        }
    }

    private static boolean makeSquare(int[] nums, int idx, int length1, int length2, int length3,
                                      int length4) {
        if (length1 < 0 || length2 < 0 || length3 < 0 || length4 < 0) {
            return false;
        }
        if (idx == nums.length) {
            if (length1 == 0 && length2 == 0 && length3 == 0 && length4 == 0) {
                return true;
            }
            return false;
        }
        return makeSquare(nums, idx + 1, length1 - nums[idx], length2, length3, length4) ||
            makeSquare(nums, idx + 1, length1, length2 - nums[idx], length3, length4) ||
            makeSquare(nums, idx + 1, length1, length2, length3 - nums[idx], length4) ||
            makeSquare(nums, idx + 1, length1, length2, length3, length4 - nums[idx]);
    }
}
