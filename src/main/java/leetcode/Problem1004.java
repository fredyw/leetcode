package leetcode;

/**
 * https://leetcode.com/problems/max-consecutive-ones-iii/
 */
public class Problem1004 {
    public int longestOnes(int[] A, int K) {
        int answer = 0;
        int left = 0;
        int right = 0;
        while (right < A.length) {
            if (A[right] == 0) {
                K--;
            }
            while (K < 0 && left <= right) {
                if (A[left] == 0) {
                    K++;
                }
                left++;
            }
            right++;
            answer = Math.max(answer, right - left);
        }
        return answer;
    }
}
