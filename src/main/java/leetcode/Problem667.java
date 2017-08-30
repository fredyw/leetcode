package leetcode;

/**
 * https://leetcode.com/problems/beautiful-arrangement-ii/
 */
public class Problem667 {
    public int[] constructArray(int n, int k) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem667 prob = new Problem667();
        System.out.println(prob.constructArray(3, 1)); // [1,2,3]
        System.out.println(prob.constructArray(3, 2)); // [1,3,2]
        System.out.println(prob.constructArray(10, 9)); // [1,10,2,9,3,8,4,7,5,6]
        System.out.println(prob.constructArray(10, 5)); // [1,6,2,5,3,4,7,8,9,10]
    }
}
