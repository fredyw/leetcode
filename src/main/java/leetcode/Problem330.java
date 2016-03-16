package leetcode;

/**
 * https://leetcode.com/problems/patching-array/
 */
public class Problem330 {
    public int minPatches(int[] nums, int n) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem330 prob = new Problem330();
        System.out.println(prob.minPatches(new int[]{1, 3}, 6)); // 1
        System.out.println(prob.minPatches(new int[]{1, 5, 10}, 20)); // 2
        System.out.println(prob.minPatches(new int[]{1, 2, 2}, 5)); // 0
    }
}
