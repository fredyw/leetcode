package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * https://leetcode.com/problems/pyramid-transition-matrix/
 */
public class Problem756 {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        // TODO
        Map<String, List<Character>> map = new HashMap<>();
        for (String s : allowed) {
            String first = s.substring(0, 2);
            char second = s.charAt(2);
            if (!map.containsKey(first)) {
                List<Character> list = new ArrayList<>();
                list.add(second);
                map.put(first, list);
            } else {
                map.get(first).add(second);
            }
        }
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < bottom.length(); i++) {
            queue.add(bottom.charAt(i));
        }
        while (!queue.isEmpty()) {

            // TODO: ???
        }
        return false;
    }

    private static boolean pyramidTransition(String bottom,
                                             Map<String, List<Character>> map,
                                             Queue<Character> queue) {
        while (!queue.isEmpty()) {
            char c1 = queue.remove();
            if (queue.isEmpty()) {
                return true;
            }
            char c2 = queue.remove();
            String s = "" + c1 + c2;
            if (!map.containsKey(s)) {
                return false;
            }
            pyramidTransition();
        }
    }

    public static void main(String[] args) {
        Problem756 prob = new Problem756();
        System.out.println(prob.pyramidTransition("XYZ", Arrays.asList("XYD", "YZE", "DEA", "FFF"))); // true
        System.out.println(prob.pyramidTransition("XXYX", Arrays.asList("XXX", "XXY", "XYX", "XYY", "YXZ"))); // false
        System.out.println(prob.pyramidTransition("ABC", Arrays.asList("ABD", "BCE", "DEF", "FFF"))); // true
        System.out.println(prob.pyramidTransition("XXX", Arrays.asList("XXX", "XXX", "XXX", "FFF"))); // true
        System.out.println(prob.pyramidTransition("ABCD", Arrays.asList("BCE","BCF","ABA","CDA","AEG","FAG","GGG"))); // false
    }
}
