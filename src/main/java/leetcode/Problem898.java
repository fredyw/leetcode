package leetcode;

/**
 * https://leetcode.com/problems/bitwise-ors-of-subarrays/
 */
public class Problem898 {
    public int subarrayBitwiseORs(int[] A) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem898 prob = new Problem898();
        System.out.println(prob.subarrayBitwiseORs(new int[]{0})); // 1
        System.out.println(prob.subarrayBitwiseORs(new int[]{1, 1, 2})); // 3
        System.out.println(prob.subarrayBitwiseORs(new int[]{1, 2, 4})); // 6
    }
}
