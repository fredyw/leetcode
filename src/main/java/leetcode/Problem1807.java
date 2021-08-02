package leetcode;

import java.util.List;

/**
 * https://leetcode.com/problems/evaluate-the-bracket-pairs-of-a-string/
 */
public class Problem1807 {
    public String evaluate(String s, List<List<String>> knowledge) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1807 prob = new Problem1807();
        System.out.println(prob.evaluate(
            "(name)is(age)yearsold",
            List.of(List.of("name","bob"),List.of("age","two")))); // "bobistwoyearsold"
        System.out.println(prob.evaluate(
            "hi(name)",
            List.of(List.of("a","b")))); // "hi?"
        System.out.println(prob.evaluate(
            "(a)(a)(a)aaa",
            List.of(List.of("a","yes")))); // "yesyesyesaaa"
        System.out.println(prob.evaluate(
            "(a)(b)",
            List.of(List.of("a","b"), List.of("b", "a")))); // "ba"
    }
}
