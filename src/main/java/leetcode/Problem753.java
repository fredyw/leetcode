package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/open-the-lock/description/
 */
public class Problem753 {
    public int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>();
        for (String dead : deadends) {
            deads.add(dead);
        }
        int result = -1;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        while (!queue.isEmpty()) {
            String current = queue.remove();
            if (deads.contains(current)) {
                continue;
            }
            for (String neighbor : getNeighbors(current)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        return -1;
    }

    private static List<String> getNeighbors(String node) {
        List<String> neighbors = new ArrayList<>();
        for (int i = 0; i < node.length(); i++) {
            int n1 = (node.charAt(i) - '0' - 1) % 10;
            neighbors.add(node.substring(0, i) + n1 + node.substring(i + 1));
            int n2 = (node.charAt(i) - '0' + 1) % 10;
            neighbors.add(node.substring(0, i) + n2 + node.substring(i + 1));
        }
        return neighbors;
    }

    public static void main(String[] args) {
        Problem753 prob = new Problem753();
        System.out.println(prob.openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202")); // 6
        System.out.println(prob.openLock(new String[]{"8888"}, "0009")); // 1
        System.out.println(prob.openLock(new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"}, "8888")); // -1
        System.out.println(prob.openLock(new String[]{"0000"}, "8888")); // -1
//        System.out.println("1234".substring(0, 1) + '0' + "1234".substring(2));
    }
}
