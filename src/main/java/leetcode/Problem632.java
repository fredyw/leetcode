package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/smallest-range/
 */
public class Problem632 {
    public int[] smallestRange(List<List<Integer>> nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> list = nums.get(i);
            for (int j = 0; j < list.size(); j++) {
                int val = list.get(j);
                boolean found = true;
                for (int k = 0; k < nums.size(); k++) {
                    int lo = nums.get(k).get(0);
                    int hi = nums.get(k).get(nums.get(k).size() - 1);
                    if (lo > val || val > hi) {
                        found = false;
                    }
                }
                if (found) {
                    set.add(val);
                }
            }
        }
        int[] result = new int[2];
        int i = 0;
        int prev = 0;
        int min = Integer.MAX_VALUE;
        for (int val : set) {
            if (i == 0) {
                prev = val;
            } else {
                int diff = val - prev;
                if (diff < min) {
                    diff = min;
                    result[0] = prev;
                    result[1] = val;
                }
                prev = val;
            }
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        Problem632 prob = new Problem632();
        System.out.println(Arrays.toString(prob.smallestRange(Arrays.asList(
            Arrays.asList(4, 10, 15, 24, 26),
            Arrays.asList(0, 9, 12, 20),
            Arrays.asList(5, 18, 22, 30)
        )))); // [20,24]
    }
}
