package leetcode;

import java.util.List;

/**
 * https://leetcode.com/problems/minimum-absolute-difference/
 */
public class Problem1600 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1600 prob = new Problem1600();
        System.out.println(prob.minimumAbsDifference(new int[]{4,2,1,3})); // [[1,2],[2,3],[3,4]]
        System.out.println(prob.minimumAbsDifference(new int[]{1,3,6,10,15})); // [[1,3]]
        System.out.println(prob.minimumAbsDifference(new int[]{3,8,-10,23,19,-4,-14,27})); // [[-14,-10],[19,23],[23,27]]
    }
}
