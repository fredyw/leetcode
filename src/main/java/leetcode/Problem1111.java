package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/
 */
public class Problem1111 {
    public int[] maxDepthAfterSplit(String seq) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1111 prob = new Problem1111();
        System.out.println(Arrays.toString(prob.maxDepthAfterSplit("(()())"))); // [0,1,1,1,1,0]
        System.out.println(Arrays.toString(prob.maxDepthAfterSplit("()(())()"))); // [0,0,0,1,1,0,1,1]
        System.out.println(Arrays.toString(prob.maxDepthAfterSplit("()(()())"))); // [0,0,0,1,0,0,0,1]
    }
}
