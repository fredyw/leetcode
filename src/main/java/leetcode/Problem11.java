package leetcode;

/**
 * https://leetcode.com/problems/container-with-most-water/
 */
public class Problem11 {
    public int maxArea(int[] height) {
        int max = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            int area = Math.min(height[i], height[j]) * (j - i);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
            max = Math.max(max, area);
        }
        return max;
    }
}
