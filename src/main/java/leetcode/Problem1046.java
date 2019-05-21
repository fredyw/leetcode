package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/last-stone-weight/
 */
public class Problem1046 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : stones) {
            queue.add(stone);
        }
        while (!queue.isEmpty()) {
            Integer x = queue.poll();
            if (queue.isEmpty()) {
                return x;
            }
            Integer y = queue.poll();
            int diff = Math.max(x, y) - Math.min(x, y);
            if (diff > 0) {
                queue.add(diff);
            }
        }
        return 0;
    }
}
