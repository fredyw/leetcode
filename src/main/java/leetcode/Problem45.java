package leetcode;

/**
 * https://leetcode.com/problems/jump-game-ii/
 */
public class Problem45 {
    public int jump(int[] nums) {
        int result = 0;
        int i = 0;
        while (i < nums.length - 1) {
            int idx = 0;
            int nextIdx = 0;
            for (int j = i; j <= i + nums[i] && j < nums.length; j++) {
                if (j + nums[j] > nextIdx) {
                    idx = j;
                    nextIdx = j + nums[j];
                }
            }
            result++;
            if (idx == i) {
                i = i + nums[i];
            } else {
                i = idx;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Problem45 prob = new Problem45();
//        System.out.println(prob.jump(new int[]{2, 3, 1, 1, 4})); // 2
//        System.out.println(prob.jump(new int[]{2, 6, 1, 1, 4})); // 2
//        System.out.println(prob.jump(new int[]{2, 2, 3, 1, 2, 4, 1})); // 3
//        System.out.println(prob.jump(new int[]{100, 5, 1, 1, 4})); // 1
//        System.out.println(prob.jump(new int[]{5})); // 0
        System.out.println(prob.jump(new int[]{2, 3, 1})); // 1
//        System.out.println(prob.jump(new int[]{1, 2, 1, 1, 1})); // 3
//        System.out.println(prob.jump(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 0})); // 2
//        System.out.println(prob.jump(new int[]{10, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0})); // 2
    }
}
