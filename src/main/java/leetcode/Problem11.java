package leetcode;

/**
 * https://leetcode.com/problems/container-with-most-water/
 */
public class Problem11 {
    public int maxArea(int[] height) {
        int answer = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            answer = Math.max(answer, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return answer;
    }
}
