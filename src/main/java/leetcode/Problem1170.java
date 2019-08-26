package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/compare-strings-by-frequency-of-the-smallest-character/
 */
public class Problem1170 {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1170 prob = new Problem1170();
        System.out.println(Arrays.toString(prob.numSmallerByFrequency(new String[]{"cbd"}, new String[]{"zaaaz"}))); // [1]
        System.out.println(Arrays.toString(prob.numSmallerByFrequency(new String[]{"bbb","cc"}, new String[]{"a","aa","aaa","aaaa"}))); // [1,2]
    }
}
