package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/
 */
public class Problem914 {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int val : deck) {
            int count = map.getOrDefault(val, 0) + 1;
            map.put(val, count);
        }
        int min = Integer.MAX_VALUE;
        for (int count : map.values()) {
            min = Math.min(min, count);
            if (min < 2) {
                return false;
            }
        }
        for (int count : map.values()) {
            if (count % min != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Problem914 prob = new Problem914();
//        System.out.println(prob.hasGroupsSizeX(new int[]{1, 2, 3, 4, 4, 3, 2, 1})); // true
//        System.out.println(prob.hasGroupsSizeX(new int[]{1, 1, 1, 2, 2, 2, 3, 3})); // false
//        System.out.println(prob.hasGroupsSizeX(new int[]{1})); // false
//        System.out.println(prob.hasGroupsSizeX(new int[]{1, 1})); // true
//        System.out.println(prob.hasGroupsSizeX(new int[]{1, 1, 2, 2, 2, 2})); // true
//        System.out.println(prob.hasGroupsSizeX(new int[]{1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3})); // true
//        System.out.println(prob.hasGroupsSizeX(new int[]{1, 1, 1, 2, 2, 2})); // true
//        System.out.println(prob.hasGroupsSizeX(new int[]{1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3})); // false
        System.out.println(prob.hasGroupsSizeX(new int[]{1, 1, 1, 1, 2, 2, 2, 2, 2, 2})); // true
//        System.out.println(prob.hasGroupsSizeX(new int[]{1, 1, 1, 2, 2, 2, 2, 2})); // false
    }
}
