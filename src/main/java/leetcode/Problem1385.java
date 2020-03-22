package leetcode;

/**
 * https://leetcode.com/problems/find-the-distance-value-between-two-arrays/
 */
public class Problem1385 {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1385 prob = new Problem1385();
        System.out.println(prob.findTheDistanceValue(new int[]{4,5,8}, new int[]{10,9,1,8}, 2)); // 2
        System.out.println(prob.findTheDistanceValue(new int[]{1,4,2,3}, new int[]{-4,-3,6,10,20,30}, 3)); // 2
        System.out.println(prob.findTheDistanceValue(new int[]{2,1,100,3}, new int[]{-5,-2,10,-3,7}, 6)); // 1
    }
}
