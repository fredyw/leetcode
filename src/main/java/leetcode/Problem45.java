package leetcode;

/**
 * https://leetcode.com/problems/jump-game-ii/
 */
public class Problem45 {
    public int jump(int[] nums) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem45 prob = new Problem45();
        System.out.println(prob.jump(new int[]{2, 3, 1, 1, 4})); // 2
        System.out.println(prob.jump(new int[]{2, 6, 1, 1, 4})); // 2
        System.out.println(prob.jump(new int[]{100, 5, 1, 1, 4})); // 1
        System.out.println(prob.jump(new int[]{5})); // 0
    }
}
