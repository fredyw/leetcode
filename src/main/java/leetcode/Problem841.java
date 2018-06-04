package leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/keys-and-rooms/
 */
public class Problem841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;
        canVisitAllRooms(rooms, rooms.get(0), visited);
        boolean result = true;
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        return result;
    }

    private static void canVisitAllRooms(List<List<Integer>> rooms,
                                         List<Integer> keys,
                                         boolean[] visited) {
        for (int key : keys) {
            if (!visited[key]) {
                visited[key] = true;
                canVisitAllRooms(rooms, rooms.get(key), visited);
            }
        }
    }

    public static void main(String[] args) {
        Problem841 prob = new Problem841();
        System.out.println(prob.canVisitAllRooms(Arrays.asList(
            Arrays.asList(1),
            Arrays.asList(2),
            Arrays.asList(3),
            Arrays.asList())
        )); // true
        System.out.println(prob.canVisitAllRooms(Arrays.asList(
            Arrays.asList(1, 3),
            Arrays.asList(3, 0, 1),
            Arrays.asList(2),
            Arrays.asList(0)
        ))); // false
    }
}
