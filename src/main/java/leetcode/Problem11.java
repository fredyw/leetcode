package leetcode;

/**
 * https://leetcode.com/problems/container-with-most-water/
 */
public class Problem11 {
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            int area = 0;
            System.out.println("idx: " + i);
            for (int j = i+1; j < height.length; j++) {
                if (height[i] < height[j]) {
                    area = height[i] * (j-i);
                    System.out.println("  area: " + area);
                } else {
                    area = height[j] * (j-i);
                    System.out.println("  area: " + area);
                }
            }
            max = Math.max(max, area);
        }
        return max;
    }
    
    public static void main(String[] args) {
        Problem11 prob = new Problem11();
        System.out.println(prob.maxArea(new int[]{2, 3, 4, 5})); // 6
        System.out.println(prob.maxArea(new int[]{2, 1})); // 1
        System.out.println(prob.maxArea(new int[]{1, 2, 1, 1, 3})); // 6
        System.out.println(prob.maxArea(new int[]{1, 2, 1, 1, 1})); // 4
    }
}
