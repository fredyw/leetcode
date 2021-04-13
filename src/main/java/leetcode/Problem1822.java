package leetcode;

/**
 * https://leetcode.com/problems/sign-of-the-product-of-an-array/
 */
public class Problem1822 {
    public int arraySign(int[] nums) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1822 prob = new Problem1822();
        System.out.println(prob.arraySign(new int[]{-1,-2,-3,-4,3,2,1})); // 1
        System.out.println(prob.arraySign(new int[]{1,5,0,2,-3})); // 0
        System.out.println(prob.arraySign(new int[]{-1,1,-1,1,-1})); // -1
    }
}
