package leetcode;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/furthest-building-you-can-reach/
 */
public class Problem1642 {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for (int i = 1; i < heights.length; i++) {
            int diff = heights[i] - heights[i - 1];
            if (diff > 0) {
                pq.add(diff);
                bricks -= diff;
                if (bricks < 0) {
                    ladders--;
                    bricks += pq.poll();
                    if (bricks < 0 || ladders < 0) {
                        return i - 1;
                    }
                }
            }
        }
        return heights.length - 1;
    }
}
