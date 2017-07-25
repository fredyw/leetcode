package leetcode;

/**
 * https://leetcode.com/problems/set-mismatch/
 */
public class Problem645 {
    public int[] findErrorNums(int[] nums) {
        int duplicate = 0;
        boolean[] b = new boolean[nums.length];
        for (int num : nums) {
            if (b[num - 1]) {
                duplicate = num;
            }
            b[num - 1] = true;
        }
        int missing = 0;
        for (int i = 0; i < b.length; i++) {
            if (!b[i]) {
                missing = i + 1;
                break;
            }
        }
        return new int[]{duplicate, missing};
    }
}
