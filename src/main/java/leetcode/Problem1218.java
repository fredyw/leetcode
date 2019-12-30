package leetcode;

/**
 * https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/
 */
public class Problem1218 {
    public int longestSubsequence(int[] arr, int difference) {
        int answer = 0;
        Integer[][] memo = new Integer[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            answer = Math.max(answer, longestSubsequence(arr, difference, i, i + 1, memo) + 1);
        }
        return answer;
    }

    private static int longestSubsequence(int[] arr,
                                          int difference,
                                          int previousIndex,
                                          int currentIndex,
                                          Integer[][] memo) {
        if (arr.length == currentIndex) {
            return 0;
        }
        if (memo[previousIndex][currentIndex] != null) {
            return memo[previousIndex][currentIndex];
        }
        int max;
        if (arr[currentIndex] == arr[previousIndex] + difference) {
            max = longestSubsequence(arr, difference, currentIndex, currentIndex + 1, memo) + 1;
        } else {
            max = longestSubsequence(arr, difference, previousIndex, currentIndex + 1, memo);
        }
        memo[previousIndex][currentIndex] = max;
        return max;
    }

    public static void main(String[] args) {
        Problem1218 prob = new Problem1218();
        System.out.println(prob.longestSubsequence(new int[]{1, 2, 3, 4}, 1)); // 4
        System.out.println(prob.longestSubsequence(new int[]{1, 3, 5, 7}, 1)); // 1
        System.out.println(prob.longestSubsequence(new int[]{1, 5, 7, 8, 5, 3, 4, 2, 1}, -2)); // 4
        System.out.println(prob.longestSubsequence(new int[]{2, -6, -3, -6, 2, 0}, -2)); // 2
        System.out.println(prob.longestSubsequence(new int[]{3, 4, -3, -2, -4}, -5)); // 2
        System.out.println(prob.longestSubsequence(new int[]{3, 1, -2}, -5)); // 2
        System.out.println(prob.longestSubsequence(new int[]{1, 2}, 1)); // 2
    }
}
