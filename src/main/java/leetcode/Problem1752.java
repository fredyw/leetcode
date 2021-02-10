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
        int current = index;
        int next = (index + 1) % nums.length;
        while (next != index) {
            if (nums[current] > nums[next]) {
                return false;
            }
            current = (current + 1) % nums.length;
            next = (next + 1) % nums.length;
        }
        return true;
    }

    public static void main(String[] args) {
        Problem1752 prob = new Problem1752();
//        System.out.println(prob.check(new int[]{3,4,5,1,2})); // true
//        System.out.println(prob.check(new int[]{2,1,3,4})); // false
//        System.out.println(prob.check(new int[]{1,2,3})); // true
//        System.out.println(prob.check(new int[]{1,1,1})); // true
//        System.out.println(prob.check(new int[]{2,1})); // true
        System.out.println(prob.check(new int[]{6,10,6})); // true
    }
}
