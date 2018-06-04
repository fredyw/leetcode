package leetcode;

/**
 * https://leetcode.com/problems/backspace-string-compare/
 */
public class Problem844 {
    public boolean backspaceCompare(String S, String T) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem844 prob = new Problem844();
        System.out.println(prob.backspaceCompare("ab#c", "ad#c")); // true
        System.out.println(prob.backspaceCompare("ab##", "c#d#")); // true
        System.out.println(prob.backspaceCompare("a##c", "#a#c")); // true
        System.out.println(prob.backspaceCompare("a#c", "b")); // false
    }
}
