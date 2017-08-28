package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/split-array-into-consecutive-subsequences/
 */
public class Problem659 {
    public boolean isPossible(int[] nums) {
        List<ValCount> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            boolean newSub = true;
            int idx = -1;
            for (int j = 0; j < list.size(); j++) {
                ValCount vc = list.get(j);
                if (vc.val + 1 == nums[i]) {
                    newSub = false;
                    if (idx == -1) {
                        idx = j;
                    } else {
                        if (list.get(idx).count > list.get(j).count) {
                            idx = j;
                        }
                    }
                }
            }
            if (newSub) {
                list.add(new ValCount(nums[i], 1));
            } else {
                list.set(idx, new ValCount(nums[i], list.get(idx).count + 1));
            }
        }
        for (ValCount vc : list) {
            if (vc.count < 3) {
                return false;
            }
        }
        return true;
    }

    private static class ValCount {
        private int val;
        private int count;

        public ValCount(int val, int count) {
            this.val = val;
            this.count = count;
        }

        @Override
        public String toString() {
            return "" + val + " --> " + count;
        }
    }

    public static void main(String[] args) {
        Problem659 prob = new Problem659();
        System.out.println(prob.isPossible(new int[]{1, 2, 3, 3, 4, 5})); // true
        System.out.println(prob.isPossible(new int[]{1, 2, 3, 3, 4, 4, 5, 5})); // true
        System.out.println(prob.isPossible(new int[]{1, 2, 3, 4, 4, 5})); // false
        System.out.println(prob.isPossible(new int[]{1, 2, 3, 3, 4, 4, 5, 6})); // true
        System.out.println(prob.isPossible(new int[]{1, 2, 3, 3, 4, 4, 5})); // true
        System.out.println(prob.isPossible(new int[]{1, 2, 3, 3, 4, 4})); // false
        System.out.println(prob.isPossible(new int[]{1, 3, 5})); // false
    }
}
