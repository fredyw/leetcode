package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/employee-importance/
 */
public class Problem690 {
    private static class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        private int id;
        // the importance importance of this employee
        private int importance;
        // the id of direct subordinates
        private List<Integer> subordinates;

        public Employee(int id, int importance, List<Integer> subordinates) {
            this.id = id;
            this.importance = importance;
            this.subordinates = subordinates;
        }
    }

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, List<Node>> adjList = new HashMap<>();
        Map<Integer, Node> nodeMap = new HashMap<>();
        for (Employee employee : employees) {
            if (!nodeMap.containsKey(employee.id)) {
                nodeMap.put(employee.id, new Node(employee.id, employee.importance));
            }
        }
        for (Employee employee : employees) {
            if (!adjList.containsKey(employee.id)) {
                adjList.put(employee.id, new ArrayList<>());
            }
            for (int subordinate : employee.subordinates) {
                adjList.get(employee.id).add(nodeMap.get(subordinate));
            }
        }
        return getImportance(adjList, id, nodeMap, new HashSet<>());
    }

    private static int getImportance(Map<Integer, List<Node>> adjList, int id,
                                     Map<Integer, Node> nodeMap, Set<Integer> visited) {
        if (visited.contains(id)) {
            return 0;
        }
        visited.add(id);
        Node root = nodeMap.get(id);
        List<Node> children = adjList.get(root.id);
        int total = root.importance;
        if (children != null) {
            for (Node child : children) {
                total += getImportance(adjList, child.id, nodeMap, visited);
            }
        }
        return total;
    }

    private static class Node {
        private final int id;
        private final int importance;

        public Node(int id, int importance) {
            this.id = id;
            this.importance = importance;
        }
    }
}
