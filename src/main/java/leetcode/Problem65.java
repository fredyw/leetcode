package leetcode;

/**
 * https://leetcode.com/problems/valid-number/
 */
public class Problem65 {
    public boolean isNumber(String s) {
        return s.matches("\\s*(?:-|\\+)?(\\d+|(?:\\d+\\.\\d*)|(?:\\d*\\.\\d+))(e(?:-|\\+)?\\d+)?\\s*");
    }
}
