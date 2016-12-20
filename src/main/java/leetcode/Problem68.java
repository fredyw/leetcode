package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/text-justification/
 */
public class Problem68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        // TODO
        return result;
    }

    public static void main(String[] args) {
        Problem68 prob = new Problem68();
        // "This    is    an",
        // "example  of text",
        // "justification.  "
        System.out.println(prob.fullJustify(new String[]{
            "This", "is", "an", "example", "of", "text", "justification."}, 16));

    }
}
