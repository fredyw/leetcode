package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-case-permutation/
 */
public class Problem784 {
    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        S = S.toLowerCase();
        letterCasePermutation(S, 0, "", result);
        return result;
    }

    private static void letterCasePermutation(String s, int idx, String accu, List<String> result) {
        if (idx == s.length()) {
            result.add(accu);
            return;
        }
        char c = s.charAt(idx);
        letterCasePermutation(s, idx + 1, accu + c, result);
        if (c >= 'a' && c <= 'z') {
            letterCasePermutation(s, idx + 1, accu + ("" + c).toUpperCase(), result);
        }
    }
}
