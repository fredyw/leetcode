package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k/
 */
public class Problem1414 {
    public int findMinFibonacciNumbers(int k) {
        List<Integer> values = fibonacci(k);
        int answer = 1;
        int n = k;
        while (true) {
            int i = Collections.binarySearch(values, n);
            if (i >= 0) {
                break;
            } else {
                i = -i - 2;
                n -= values.get(i);
            }
            answer++;
        }
        return answer;
    }

    private static List<Integer> fibonacci(int k) {
        List<Integer> values = new ArrayList<>();
        int a = 0;
        int b = 0;
        int c = 1;
        while (c <= k) {
            values.add(c);
            a = b;
            b = c;
            c = a + b;
        }
        return values;
    }
}
