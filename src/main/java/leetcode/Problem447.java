package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/number-of-boomerangs/
 */
public class Problem447 {
    public int numberOfBoomerangs(int[][] points) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < points.length; i++) {
            String key = points[i][0] + "|" + points[i][1];
            set.add(key);
        }
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            int[] a = points[i];
            String keyA = a[0] + "|" + a[1];
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                int[] b = points[j];
                String keyB = b[0] + "|" + b[1];
                int diffi = Math.abs(b[0] - a[0]);
                int diffj = Math.abs(b[1] - a[1]);

                Set<String> keys = new HashSet<>();

                String key1 = (a[0] + diffi) + "|" + (a[1] + diffj);
                keys.add(key1);
                if (!key1.equals(keyB) && !key1.equals(keyA)) {
                    if (set.contains(key1)) {
                        result++;
                    }
                }

                String key2 = (a[0] - diffi) + "|" + (a[1] - diffj);
                if (!keys.contains(key2)) {
                    keys.add(key2);
                    if (!key2.equals(keyB) && !key2.equals(keyA)) {
                        if (set.contains(key2)) {
                            result++;
                        }
                    }
                }

                String key3 = (a[0] + diffi) + "|" + (a[1] - diffj);
                if (!keys.contains(key3)) {
                    keys.add(key3);
                    if (!key3.equals(keyB) && !key3.equals(keyA)) {
                        if (set.contains(key3)) {
                            result++;
                        }
                    }
                }

                String key4 = (a[0] - diffi) + "|" + (a[1] + diffj);
                if (!keys.contains(key4)) {
                    keys.add(key4);
                    if (!key4.equals(keyB) && !key4.equals(keyA)) {
                        if (set.contains(key4)) {
                            result++;
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Problem447 prob = new Problem447();
        System.out.println(prob.numberOfBoomerangs(new int[][]{{0, 0}, {1, 0}, {2, 0}})); // 2
        System.out.println(prob.numberOfBoomerangs(new int[][]{{1, 4}, {0, 8}, {2, 8}, {4, 5}})); // 2
        System.out.println(prob.numberOfBoomerangs(new int[][]{{0, 0}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}})); // 20
    }
}
