package leetcode;

/**
 * https://leetcode.com/problems/form-array-by-concatenating-subarrays-of-another-array/
 */
public class Problem1764 {
    public boolean canChoose(int[][] groups, int[] nums) {
        boolean answer = true;
        int i = 0;
        for (int[] group : groups) {
            int j = 0;
            int k = i;
            boolean found = false;
            while (j < group.length && i < nums.length) {
                while (i < nums.length && group[j] != nums[i]) {
                    i++;
                }
                for (; j < group.length && i < nums.length; i++, j++) {
                    if (group[j] != nums[i]) {
                        i = k++ + 1;
                        j = 0;
                        break;
                    }
                }
                if (j == group.length) {
                    found = true;
                }
            }
            answer &= found;
        }
        return answer;
    }
}
