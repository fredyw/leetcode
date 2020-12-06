package leetcode;

import java.util.regex.Pattern;

/**
 * https://leetcode.com/problems/goal-parser-interpretation/
 */
public class Problem1678 {
    public String interpret(String command) {
        return command.replaceAll(Pattern.quote("(al)"), "al")
            .replaceAll(Pattern.quote("()"), "o");
    }
}
