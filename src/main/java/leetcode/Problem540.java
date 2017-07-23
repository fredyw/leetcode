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
                        if ((mid - 1 - i) % 2 != 0) {
                            j = mid;
                        } else {
                            i = mid;
                        }
                    }
                }
                if (nums[mid] == nums[mid + 1]) {
                    if ((j - mid + 1) % 2 != 0) {
                        i = mid;
                    } else {
                        j = mid;
                    }
                }
            }
            if (tmpi == i && tmpj == j) {
                return nums[mid];
            }
        }
        return nums[i];
    }

    public static void main(String[] args) {
        Problem540 prob = new Problem540();
//        System.out.println(prob.singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8})); // 2
//        System.out.println(prob.singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11})); // 10
        System.out.println(prob.singleNonDuplicate(new int[]{1, 3, 3, 7, 7, 11, 11})); // 1
        System.out.println(prob.singleNonDuplicate(new int[]{1, 1, 3, 3, 7, 7, 11})); // 11
    }
}
