package leetcode;

/**
 * https://leetcode.com/problems/richest-customer-wealth/
 */
public class Problem1672 {
    public int maximumWealth(int[][] accounts) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1672 prob = new Problem1672();
        System.out.println(prob.maximumWealth(new int[][]{{1,2,3},{3,2,1}})); // 6
        System.out.println(prob.maximumWealth(new int[][]{{1,5},{7,3},{3,5}})); // 10
        System.out.println(prob.maximumWealth(new int[][]{{2,8,7},{7,1,3},{1,9,5}})); // 17
    }
}
