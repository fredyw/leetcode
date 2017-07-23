package leetcode;

/**
 * https://leetcode.com/problems/single-element-in-a-sorted-array/
 */
public class Problem540 {
    public int singleNonDuplicate(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int tmpi = i;
            int tmpj = j;
            int mid = (i + j) / 2;
            if (mid + 1 < nums.length) {
                if (mid - 1 >= 0) {
                    if (nums[mid] == nums[mid - 1]) {
                        if ((mid - 1) % 2 != 0) {
                            j = mid - 1;
                        } else {
                            i = mid + 1;
                        }
                    }
                }
                if (nums[mid] == nums[mid + 1]) {
                    if ((nums.length - 1 - mid + 1) % 2 != 0) {
                        i = mid + 1;
                    } else {
                        j = mid - 1;
                    }
                }
            }
            if (tmpi == i && tmpj == j) {
                return nums[mid];
            }
        }
        return nums[i];
    }
}
