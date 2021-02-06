package leetcode;

/**
 * https://leetcode.com/problems/tuple-with-same-product/
 */
public class Problem1726 {
    public int tupleSameProduct(int[] nums) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1726 prob = new Problem1726();
        System.out.println(prob.tupleSameProduct(new int[]{2,3,4,6})); // 8
        System.out.println(prob.tupleSameProduct(new int[]{1,2,4,5,10})); // 16
        System.out.println(prob.tupleSameProduct(new int[]{2,3,4,6,8,12})); // 40
        System.out.println(prob.tupleSameProduct(new int[]{2,3,5,7})); // 0
    }
}
