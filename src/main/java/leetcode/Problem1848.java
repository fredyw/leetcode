package leetcode;

/**
 * https://leetcode.com/problems/minimum-distance-to-the-target-element/
 */
public class Problem1848 {
    public int getMinDistance(int[] nums, int target, int start) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1848 prob = new Problem1848();
        System.out.println(prob.getMinDistance(new int[]{1,2,3,4,5}, 5, 3)); // 1
        System.out.println(prob.getMinDistance(new int[]{1}, 1, 0)); // 0
        System.out.println(prob.getMinDistance(new int[]{1,1,1,1,1,1,1,1,1,1}, 1, 0)); // 0
    }
}
