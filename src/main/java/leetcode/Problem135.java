package leetcode;

/**
 * https://leetcode.com/problems/candy/
 */
public class Problem135 {
    public int candy(int[] ratings) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem135 prob = new Problem135();
        System.out.println(prob.candy(new int[]{1, 0, 2})); // 5
        System.out.println(prob.candy(new int[]{1, 2, 2})); // 4
        System.out.println(prob.candy(new int[]{2, 2, 2})); // 3
        System.out.println(prob.candy(new int[]{2, 3, 2})); // 4
        System.out.println(prob.candy(new int[]{3, 2, 2, 3})); // 6
        System.out.println(prob.candy(new int[]{3, 2, 2, 2, 3})); // 7
        System.out.println(prob.candy(new int[]{1, 2, 2, 1})); // 6
        System.out.println(prob.candy(new int[]{1, 2, 2, 2, 1})); // 7
    }
}
