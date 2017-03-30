package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
 */
public class Problem373 {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return result;
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0] + a[1], b[0] + b[1]));
        for (int i = 0; i < k && i < nums1.length; i++) {
            queue.add(new int[]{nums1[i], nums2[0], 0});
        }
        while (k-- > 0 && !queue.isEmpty()) {
            int[] current = queue.remove();
            result.add(new int[]{current[0], current[1]});
            int idx = current[2];
            if (idx == nums2.length - 1) {
                continue;
            }
            queue.add(new int[]{current[0], nums2[idx + 1], idx + 1});
        }
        return result;
    }
}
