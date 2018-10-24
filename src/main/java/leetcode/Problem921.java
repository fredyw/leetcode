package leetcode;

/**
 * https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
 */
public class Problem921 {
    public int minAddToMakeValid(String S) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem921 prob = new Problem921();
        System.out.println(prob.minAddToMakeValid("())")); // 1
        System.out.println(prob.minAddToMakeValid("(((")); // 3
        System.out.println(prob.minAddToMakeValid("()")); // 0
        System.out.println(prob.minAddToMakeValid("()))((")); // 4
    }
}
