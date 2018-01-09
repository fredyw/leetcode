package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/pyramid-transition-matrix/
 */
public class Problem756 {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        // TODO
        Queue<Character> queue = new LinkedList<>();
        return false;
    }

    public static void main(String[] args) {
        Problem756 prob = new Problem756();
        System.out.println(prob.pyramidTransition("XYZ", Arrays.asList("XYD", "YZE", "DEA", "FFF"))); // true
        System.out.println(prob.pyramidTransition("XXYX", Arrays.asList("XXX", "XXY", "XYX", "XYY", "YXZ"))); // false
        System.out.println(prob.pyramidTransition("ABC", Arrays.asList("ABD", "BCE", "DEF", "FFF"))); // true
        System.out.println(prob.pyramidTransition("XXX", Arrays.asList("XXX", "XXX", "XXX", "FFF"))); // true
    }
}
