package leetcode;

/**
 * https://leetcode.com/problems/k-concatenation-maximum-sum/
 */
public class Problem1191 {
    public int kConcatenationMaxSum(int[] arr, int k) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1191 prob = new Problem1191();
        System.out.println(prob.kConcatenationMaxSum(new int[]{1,2}, 3)); // 9
        System.out.println(prob.kConcatenationMaxSum(new int[]{1,-2,1}, 5)); // 2
        System.out.println(prob.kConcatenationMaxSum(new int[]{-1,-2}, 7)); // 0
    }
}
