package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/incremental-memory-leak/
 */
public class Problem1860 {
    public int[] memLeak(int memory1, int memory2) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1860 prob = new Problem1860();
        System.out.println(Arrays.toString(prob.memLeak(2, 2))); // [3,1,0]
        System.out.println(Arrays.toString(prob.memLeak(8, 11))); // [6,0,4]
    }
}
