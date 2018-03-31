package leetcode;

/**
 * https://leetcode.com/problems/circular-array-loop/
 */
public class Problem457 {
    public boolean circularArrayLoop(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            int j = i + nums[i];
            j %= nums.length;
            if (j < 0) {
                j = nums.length + j;
            }
            boolean found = false;
            boolean skip = false;
            while (!visited[j]) {
                if (nums[i] < 0 != nums[j] < 0) {
                    skip = true;
                }
                visited[j] = true;
                j += nums[j];
                j %= nums.length;
                if (j < 0) {
                    j = nums.length + j;
                }
                if (i == j && !skip) {
                    found = true;
                }
            }
            if (found) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Problem457 prob = new Problem457();
        System.out.println(prob.circularArrayLoop(new int[]{2, -1, 1, 2, 2})); // true
        System.out.println(prob.circularArrayLoop(new int[]{2, -1, 1, 1, 2})); // false
        System.out.println(prob.circularArrayLoop(new int[]{-1, 2})); // false
        System.out.println(prob.circularArrayLoop(new int[]{-1, 1})); // false
        System.out.println(prob.circularArrayLoop(new int[]{-1, -2})); // false
        System.out.println(prob.circularArrayLoop(new int[]{-1, -1, -2})); // true
        System.out.println(prob.circularArrayLoop(new int[]{1, -1})); // false
        System.out.println(prob.circularArrayLoop(new int[]{3, 1, 2})); // true
        System.out.println(prob.circularArrayLoop(new int[]{2, 1, -1, -2, -2})); // false
    }
}
