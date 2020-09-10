package leetcode;

/**
 * https://leetcode.com/problems/find-the-winner-of-an-array-game/
 */
public class Problem1535 {
    public int getWinner(int[] arr, int k) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1535 prob = new Problem1535();
        System.out.println(prob.getWinner(new int[]{2,1,3,5,4,6,7}, 2)); // 5
        System.out.println(prob.getWinner(new int[]{3,2,1}, 10)); // 3
        System.out.println(prob.getWinner(new int[]{1,9,8,2,3,7,6,4,5}, 7)); // 9
        System.out.println(prob.getWinner(new int[]{1,11,22,33,44,55,66,77,88,99}, 1000000000)); // 99
    }
}
