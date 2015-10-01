package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/different-ways-to-add-parentheses/
 */
public class Problem241 {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();

        return result;
    }

    public static void main(String[] args) {
        Problem241 prob = new Problem241();
        System.out.println(prob.diffWaysToCompute("2-1-1"));
        System.out.println(prob.diffWaysToCompute("2*3-4*5"));
    }
}
