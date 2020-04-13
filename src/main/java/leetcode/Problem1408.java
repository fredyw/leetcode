package leetcode;

import java.util.List;

/**
 * https://leetcode.com/problems/string-matching-in-an-array/
 */
public class Problem1408 {
    public List<String> stringMatching(String[] words) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1408 prob = new Problem1408();
        System.out.println(prob.stringMatching(new String[]{"mass","as","hero","superhero"})); // ["as","hero"]
        System.out.println(prob.stringMatching(new String[]{"leetcode","et","code"})); // ["et","code"]
        System.out.println(prob.stringMatching(new String[]{"blue","green","bu"})); // []
        System.out.println(prob.stringMatching(new String[]{"mass","as","hero","mas","superhero"})); // ["as","hero","mas"]
    }
}
