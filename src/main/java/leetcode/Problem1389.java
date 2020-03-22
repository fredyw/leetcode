package leetcode;

/**
 * https://leetcode.com/problems/create-target-array-in-the-given-order/
 */
public class Problem1389 {
    public int[] createTargetArray(int[] nums, int[] index) {
        int[] answer = new int[0];
        for (int i = 0; i < nums.length; i++) {
            int[] tmp = new int[i + 1];
            for (int j = 0; j < index[i]; j++) {
                tmp[j] = answer[j];
            }
            for (int j = index[i]; j < answer.length; j++) {
                tmp[j + 1] = answer[j];
            }
            tmp[index[i]] = nums[i];
            answer = tmp;
        }
        return answer;
    }
}
