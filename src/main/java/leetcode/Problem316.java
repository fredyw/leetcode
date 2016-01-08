package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/remove-duplicate-letters/
 */
public class Problem316 {
    public String removeDuplicateLetters(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        int set = 0;
        int dup = 0;
        for (char c : chars) {
            int idx = 1 << (c - 97);
            if ((idx & set) > 0) {
                dup |= idx;
            }
            set |= idx;
        }
        System.out.println(Integer.toBinaryString(dup));
        StringBuilder sb = new StringBuilder();
        // TODO:
        return sb.toString();
    }

    public static void main(String[] args) {
        Problem316 prob = new Problem316();
//        System.out.println(prob.removeDuplicateLetters("bcabc")); // abc
//        System.out.println(prob.removeDuplicateLetters("bbcaac")); // bac
        System.out.println(prob.removeDuplicateLetters("cbacdcbc")); // acdb
    }
}
