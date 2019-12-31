package leetcode;

/**
 * https://leetcode.com/problems/jump-game-iii/
 */
public class Problem1306 {
    public boolean canReach(int[] arr, int start) {
        return canReach(arr, start, new boolean[arr.length]);
    }

    private static boolean canReach(int[] arr, int index, boolean[] visited) {
        if (visited[index]) {
            return false;
        }
        if (arr[index] == 0) {
            return true;
        }
        visited[index] = true;
        boolean a = index + arr[index] < arr.length ? canReach(arr, index + arr[index], visited) : false;
        boolean b = index - arr[index] >= 0 ? canReach(arr, index - arr[index], visited) : false;
        return a || b;
    }
}
