package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
 */
public class Problem373 {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // TODO
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        Problem373 prob = new Problem373();

        System.out.println(prob.kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3)); //  [1,2],[1,4],[1,6]
        System.out.println(prob.kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 3)); // [1,1],[1,1]
        System.out.println(prob.kSmallestPairs(new int[]{1, 2}, new int[]{3}, 2)); // [1,3],[2,3]
    }
}
