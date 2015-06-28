package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/contains-duplicate-ii/
 */
public class Problem219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // the key is the num value, the value is the index
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                int idx = map.get(num);
                if (Math.abs(i - idx) <= k) {
                    return true;
                }
            }
            map.put(num, i);
        }
        return false;
    }

    public static void main(String[] args) {
        Problem219 prob = new Problem219();
        System.out.println(prob.containsNearbyDuplicate(new int[]{99, 99}, 2));
    }
}
