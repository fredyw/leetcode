package leetcode;

import java.util.List;

/**
 * https://leetcode.com/problems/count-items-matching-a-rule/
 */
public class Problem1773 {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1773 prob = new Problem1773();
        System.out.println(prob.countMatches(List.of(
            List.of("phone","blue","pixel"),
            List.of("computer","silver","lenovo"),
            List.of("phone","gold","iphone")),
            "color", "silver")); // 1
        System.out.println(prob.countMatches(List.of(
            List.of("phone","blue","pixel"),
            List.of("computer","silver","lenovo"),
            List.of("phone","gold","iphone")),
            "color", "phone")); // 2
    }
}
