package leetcode;

import java.util.TreeSet;

/**
 * https://leetcode.com/problems/contains-duplicate-iii/
 */
public class Problem220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k <= 0 || t < 0 || nums.length <= 1) {
            return false;
        }
        TreeSet<Integer> set = new TreeSet<>();
        int size = k + 1;
        if (size > nums.length) {
            size = nums.length;
        }
        for (int i = 0; i < size; i++) {
            set.add(nums[i]);
        }
        if (set.size() != size) {
            return true;
        }
        int a = set.first();
        int b = 0;
        if (set.size() > 1) {
            b = set.higher(set.first());
        }
        long diff = Math.abs((long) a - (long) b);
        if (diff <= (long) t) {
            return true;
        }
        int j = 0;
        for (int i = k + 1; i < nums.length; i++) {
            set.remove(nums[j]);
            set.add(nums[i]);
            if (set.size() != size) {
                return true;
            }
            a = set.first();
            b = 0;
            if (set.size() > 1) {
                b = set.higher(set.first());
            }
            diff = Math.abs((long) a - (long) b);
            if (diff <= (long) t) {
                return true;
            }
            j++;
        }
        a = set.pollFirst();
        while (!set.isEmpty()) {
            b = set.pollFirst();
            diff = (long) Math.abs((long) a - (long) b);
            if (diff <= (long) t) {
                return true;
            }
            a = b;
        }
        return false;
    }
}
