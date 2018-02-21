package leetcode;

import java.util.List;

/**
 * https://leetcode.com/problems/letter-case-permutation/
 */
public class Problem784 {
    public List<String> letterCasePermutation(String S) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem784 prob = new Problem784();
        System.out.println(prob.letterCasePermutation("a1b2")); // ["a1b2", "a1B2", "A1b2", "A1B2"]
        System.out.println(prob.letterCasePermutation("3z4")); // ["3z4", "3Z4"]
        System.out.println(prob.letterCasePermutation("12345")); // ["12345"]
    }
}
