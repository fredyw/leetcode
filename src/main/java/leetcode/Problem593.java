package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/valid-square/
 */
public class Problem593 {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        List<int[]> list = new ArrayList<>();
        list.add(p2);
        list.add(p3);
        list.add(p4);
        int[] a = p1;
        for (int i = 0; i < list.size(); i++) {
            int[] b = list.get(i);
            if (a[0] == b[0]) {
                // a <--> b (y-axis)
                int dist1 = Math.abs(a[1] - b[1]);
                list.remove(i);
                int[] c = null;
                for (int j = 0; j < list.size(); j++) {
                    if (a[1] == list.get(j)[1]) {
                        c = list.get(j);
                        list.remove(j);
                        break;
                    }
                }
                if (c == null) {
                    return false;
                }
                // a <--> c (x-axis)
                int dist2 = Math.abs(a[0] - c[0]);
                if (dist1 != dist2) {
                    return false;
                }
                int[] d = list.get(0);
                if (b[1] != d[1]) {
                    return false;
                }
                // b <--> d (x-axis)
                int dist3 = Math.abs(b[0] - d[0]);
                if (dist2 != dist3) {
                    return false;
                }
                // c <--> d (y-axis)
                int dist4 = Math.abs(c[1] - d[1]);
                if (dist3 != dist4) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Problem593 prob = new Problem593();
//        System.out.println(prob.validSquare(new int[]{0, 0}, new int[]{1, 1}, new int[]{1, 0}, new int[]{0, 1})); // true
//        System.out.println(prob.validSquare(new int[]{0, 0}, new int[]{1, 1}, new int[]{1, 5}, new int[]{0, 1})); // false
//        System.out.println(prob.validSquare(new int[]{0, 1}, new int[]{0, 0}, new int[]{1, 1}, new int[]{1, 0})); // true
//        System.out.println(prob.validSquare(new int[]{0, 1}, new int[]{0, 0}, new int[]{1, -1}, new int[]{1, 0})); // false
        System.out.println(prob.validSquare(new int[]{1, 0}, new int[]{-1, 0}, new int[]{0, 1}, new int[]{0, -1})); // true
    }
}
