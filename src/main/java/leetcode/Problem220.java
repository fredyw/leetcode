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
            System.out.println(set);
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
//        System.out.println(prob.containsNearbyAlmostDuplicate(new int[]{3, 6, 0, 4}, 2, 2)); // true
//        System.out.println(prob.containsNearbyAlmostDuplicate(new int[]{2, 2}, 3, 0)); // true
//        System.out.println(prob.containsNearbyAlmostDuplicate(new int[]{-1, 2147483647}, 1, 2147483647)); // false
    }
}
