package leetcode;

/**
 * https://leetcode.com/problems/trapping-rain-water/
 */
public class Problem42 {
    public int trap(int[] height) {
        boolean zero = true;
        int prev = 0;
        int prevIdx = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] == 0 && zero) {
                continue;
            }
            zero = false;
            if (prev >= height[i]) {
                prevIdx = i;
                prev = height[i];
                if (prev > 0) {
                    // to be continued
                }
            }
        }
        return 0;
    }
    
    public static void main(String[] args) {
        Problem42 prob = new Problem42();
        System.out.println(prob.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1})); // 6
    }
}
