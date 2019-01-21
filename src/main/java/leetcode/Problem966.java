package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/vowel-spellchecker/
 */
public class Problem966 {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        String[] answer = new String[queries.length];
        // TODO
        return queries;
    }

    public static void main(String[] args) {
        Problem966 prob = new Problem966();
        System.out.println(Arrays.toString(prob.spellchecker(
            new String[]{"KiTe", "kite", "hare", "Hare"},
            new String[]{"kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto"})));
        // ["kite","KiTe","KiTe","Hare","hare","","","KiTe","","KiTe"]
    }
}
