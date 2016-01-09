package leetcode;

/**
 * https://leetcode.com/problems/remove-duplicate-letters/
 */
public class Problem316 {
    public String removeDuplicateLetters(String s) {
        StringBuilder sb = new StringBuilder();
        return sb.toString();
    }

    public static void main(String[] args) {
        Problem316 prob = new Problem316();
//        System.out.println(prob.removeDuplicateLetters("bcabc")); // abc
//        System.out.println(prob.removeDuplicateLetters("bbcaac")); // bac
        System.out.println(prob.removeDuplicateLetters("cbacdcbc")); // acdb
    }
}
