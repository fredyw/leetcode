package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 */
public class Problem30 {
    public List<Integer> findSubstring(String s, String[] words) {
        // TODO
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        Problem30 prob = new Problem30();
        System.out.println(prob.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"})); // [0, 9]
        System.out.println(prob.findSubstring("foobarthefoobarman", new String[]{"foo", "bar"})); // [0, 9]
        System.out.println(prob.findSubstring("barbazthebarbarfoobaz", new String[]{"foo", "bar"})); // [12]
    }
}
