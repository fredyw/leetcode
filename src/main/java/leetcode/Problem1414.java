package leetcode;

/**
 * https://leetcode.com/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k/
 */
public class Problem1414 {
    public int findMinFibonacciNumbers(int k) {
        Integer[] memo = new Integer[k + 1];
        memo[1] = 1;
        memo[2] = 1;
        fibonacci(k, memo);
        int answer = Integer.MAX_VALUE;
        // TODO:
        return answer;
    }

    private static int fibonacci(int n, Integer[] memo) {
        if (n <= 2) {
            return 1;
        }
        if (memo[n] != null) {
            return memo[n];
        }
        memo[n] = fibonacci(n - 1, memo) + fibonacci(n - 2, memo);
        return memo[n];
    }

    public static void main(String[] args) {
        Problem1414 prob = new Problem1414();
        System.out.println(prob.findMinFibonacciNumbers(7)); // 2
        System.out.println(prob.findMinFibonacciNumbers(10)); // 2
        System.out.println(prob.findMinFibonacciNumbers(19)); // 3
    }
}
