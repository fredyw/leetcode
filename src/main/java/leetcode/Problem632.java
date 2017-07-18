package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/smallest-range/
 */
public class Problem632 {
    public int[] smallestRange(List<List<Integer>> nums) {
        int minx = 0;
        int miny = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int[] next = new int[nums.size()];
        boolean flag = true;
        PriorityQueue<Integer> minQueue = new PriorityQueue<>((i, j) -> nums.get(i).get(next[i]) - nums.get(j).get(next[j]));
        for (int i = 0; i < nums.size(); i++) {
            minQueue.offer(i);
            max = Math.max(max, nums.get(i).get(0));
        }
        for (int i = 0; i < nums.size() && flag; i++) {
            for (int j = 0; j < nums.get(i).size() && flag; j++) {
                int mini = minQueue.poll();
                if (miny - minx > max - nums.get(mini).get(next[mini])) {
                    minx = nums.get(mini).get(next[mini]);
                    miny = max;
                }
                next[mini]++;
                if (next[mini] == nums.get(mini).size()) {
                    flag = false;
                    break;
                }
                minQueue.offer(mini);
                max = Math.max(max, nums.get(mini).get(next[mini]));
            }
        }
        return new int[]{minx, miny};
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
