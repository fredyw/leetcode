package leetcode;

import java.util.List;

/**
 * https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/
 */
public class Problem1282 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1282 prob = new Problem1282();
        System.out.println(prob.groupThePeople(new int[]{3,3,3,3,3,1,3})); // [[5],[0,1,2],[3,4,6]]
        System.out.println(prob.groupThePeople(new int[]{2,1,3,3,3,2})); // [[1],[0,5],[2,3,4]]
    }
}
