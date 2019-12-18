package leetcode;

import java.util.List;

/**
 * https://leetcode.com/problems/sequential-digits/
 */
public class Problem1291 {
    public List<Integer> sequentialDigits(int low, int high) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1291 prob = new Problem1291();
        System.out.println(prob.sequentialDigits(100, 300)); // [123,234]
        System.out.println(prob.sequentialDigits(1000, 13000)); // [1234,2345,3456,4567,5678,6789,12345]
    }
}
