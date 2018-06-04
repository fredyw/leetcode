package leetcode;

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
}
