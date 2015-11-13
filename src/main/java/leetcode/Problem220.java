package leetcode;

import java.util.TreeSet;

/**
 * https://leetcode.com/problems/contains-duplicate-iii/
 */
public class Problem220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j <= (i + k) && j < nums.length; j++) {
//                int diff = Math.abs(nums[j] - nums[i]);
//                if (diff <= t) {
//                    return true;
//                }
//            }
//        }
        if (nums.length <= k || k <= 0 || t < 0) {
            return false;
        }
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
        System.out.println(set);
        int a = set.first();
        int b = 0;
        if (set.size() > 1) {
            b = set.higher(set.first());
        }
        int diff = Math.abs(a - b);
        if (diff <= t) {
            return true;
        }
        int j = 0;
        for (int i = k + 1; i < nums.length; i++) {
            set.remove(nums[j]);
            set.add(nums[i]);
            if (set.size() != size) {
                return true;
            }
            System.out.println(set);
            a = set.first();
            b = 0;
            if (set.size() > 1) {
                b = set.higher(set.first());
            }
            diff = Math.abs(a - b);
            if (diff <= t) {
                return true;
            }
            j++;
        }
        return false;
    }

    public static void main(String[] args) {
        Problem220 prob = new Problem220();
//        System.out.println(prob.containsNearbyAlmostDuplicate(new int[]{0}, 0, 0)); // false
//        System.out.println(prob.containsNearbyAlmostDuplicate(new int[]{1}, 1, 1)); // false
//        System.out.println(prob.containsNearbyAlmostDuplicate(new int[]{-1, -1}, 1, 0)); // true
//        System.out.println(prob.containsNearbyAlmostDuplicate(new int[]{2, 1}, 1, 1)); // true
//        System.out.println(prob.containsNearbyAlmostDuplicate(new int[]{4, 2}, 2, 1)); // false
//        System.out.println(prob.containsNearbyAlmostDuplicate(new int[]{6, 2, 4, 8, 1, 3, 2}, 3, 1)); // true
//        System.out.println(prob.containsNearbyAlmostDuplicate(new int[]{6, 2, 4, 8, 1, 3, 2}, 2, 1)); // true
//        System.out.println(prob.containsNearbyAlmostDuplicate(new int[]{6, 2, 4, 8, 1, 3, 2}, 2, 1)); // true
//        System.out.println(prob.containsNearbyAlmostDuplicate(new int[]{2, 6, 4, 2}, 3, 1)); // true
//        System.out.println(prob.containsNearbyAlmostDuplicate(new int[]{2, 6, 4, 2}, 2, 1)); // false
//        System.out.println(prob.containsNearbyAlmostDuplicate(new int[]{2, 2}, 3, 0)); // true
        System.out.println(prob.containsNearbyAlmostDuplicate(new int[]{3, 6, 0, 4}, 2, 2)); // true
    }
}
