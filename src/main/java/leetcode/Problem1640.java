package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/check-array-formation-through-concatenation/
 */
public class Problem1640 {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Arrays.sort(pieces, (a, b) -> {
            int cmp = Integer.compare(b.length, a.length);
            if (cmp == 0) {
                return Integer.compare(Arrays.toString(b).length(), Arrays.toString(a).length());
            }
            return cmp;
        });
        String str = toString(arr);
        for (int[] piece : pieces) {
            String s = toString(piece);
            int index = str.indexOf(s);
            if (index < 0) {
                return false;
            }
            str = str.substring(0, index) + str.substring(index + s.length());
        }
        return true;
    }

    private static String toString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int a : arr) {
            if (sb.length() == 0) {
                sb.append(a);
            } else {
                sb.append(",").append(a);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Problem1640 prob = new Problem1640();
        System.out.println(prob.canFormArray(new int[]{85}, new int[][]{{85}})); // true
        System.out.println(prob.canFormArray(new int[]{15,88}, new int[][]{{88},{15}})); // true
        System.out.println(prob.canFormArray(new int[]{49,18,16}, new int[][]{{16,18,49}})); // false
        System.out.println(prob.canFormArray(new int[]{91,4,64,78}, new int[][]{{78},{4,64},{91}})); // true
        System.out.println(prob.canFormArray(new int[]{91,4,64,78}, new int[][]{{78},{64,4},{91}})); // false
        System.out.println(prob.canFormArray(new int[]{1,3,5,7}, new int[][]{{2,4,6,8}})); // false
        System.out.println(prob.canFormArray(new int[]{4,56,4}, new int[][]{{4}, {4,56}})); // true
        System.out.println(prob.canFormArray(new int[]{32,66,73,15,3,70,53}, new int[][]{{66,73},{15},{3},{32},{70},{53}})); // true
        System.out.println(prob.canFormArray(new int[]{75,1,60,91,84,55,5,39,19,52,38,66,14,17,49},
            new int[][]{{60},{52,38},{66},{39},{19},{1},{84,55},{17},{14},{49},{91},{5},{75}})); // true
    }
}
