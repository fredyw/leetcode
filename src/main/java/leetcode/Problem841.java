package leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/keys-and-rooms/
 */
public class Problem841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem841 prob = new Problem841();
        System.out.println(prob.canVisitAllRooms(Arrays.asList(
            Arrays.asList(1),
            Arrays.asList(2),
            Arrays.asList(3),
            Arrays.asList())
        )); // true
    }
}
