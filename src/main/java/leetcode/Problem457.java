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
            int start = i;
            int j = i + 1;
            boolean found = true;
            while (j != start) {
                if (nums[i] < 0 != nums[j] < 0) {
                    found = false;
                }
                visited[j] = true;
                j++;
                j %= nums.length;
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
//        System.out.println(prob.circularArrayLoop(new int[]{2, -1, 1, 1, 2})); // false
//        System.out.println(prob.circularArrayLoop(new int[]{-1, 2})); // false
//        System.out.println(prob.circularArrayLoop(new int[]{-1, 1})); // false
//        System.out.println(prob.circularArrayLoop(new int[]{-1, -2})); // false
//        System.out.println(prob.circularArrayLoop(new int[]{-1, -1, -2})); // true
//        System.out.println(prob.circularArrayLoop(new int[]{1, -1})); // false
//        System.out.println(prob.circularArrayLoop(new int[]{3, 1, 2})); // true
//        System.out.println(prob.circularArrayLoop(new int[]{2, 1, -1, -2, -2})); // false
    }
}
