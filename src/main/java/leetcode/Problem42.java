package leetcode;

/**
 * https://leetcode.com/problems/trapping-rain-water/
 */
public class Problem42 {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        boolean leftTurn = false;
        int result = 0;
        while (left < right) {
            if (height[left] <= height[right]) {
                leftTurn = true;
            } else {
                leftTurn = false;
            }
            if (leftTurn) {
                int i = left + 1;
                int area = 0;
                while (height[i] < height[left] && i < right) {
                    area += height[left] - height[i];
                    i++;
                }
                result += area;
                left = i;
            } else {
                int i = right - 1;
                int area = 0;
                while (height[i] < height[right] && i > left) {
                    area += height[right] - height[i];
                    i--;
                }
                result += area;
                right = i;
            }
        }
        return result;
    }
}