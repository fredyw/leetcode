package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/accounts-merge/
 */
public class Problem721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToAccount = new HashMap<>();
        Map<String, TreeSet<String>> graph = new HashMap<>();
        for (List<String> account : accounts) {
            String name = account.get(0);
            String email = account.get(1);
            emailToAccount.put(email, name);
            if (!graph.containsKey(email)) {
                graph.put(email, new TreeSet<>());
            }
            for (int i = 2; i < account.size(); i++) {
                emailToAccount.put(account.get(i), name);
                // bidirectional
                graph.get(email).add(account.get(i));
                if (!graph.containsKey(account.get(i))) {
                    graph.put(account.get(i), new TreeSet<>());
                }
                graph.get(account.get(i)).add(email);
            }
        }
        int group = 0;
        Map<String, Integer> groups = new HashMap<>();
        Set<String> visited = new HashSet<>();
        Map<Integer, TreeSet<String>> connectedComponents = new HashMap<>();
        for (String vertex : graph.keySet()) {
            if (!visited.contains(vertex)) {
                dfs(graph, vertex, group++, groups, visited, connectedComponents);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < group; i++) {
            List<String> list = new ArrayList<>();
            TreeSet<String> emails = connectedComponents.get(i);
            int j = 0;
            for (String email : emails) {
                if (j == 0) {
                    list.add(emailToAccount.get(email));
                    list.add(email);
                } else {
                    list.add(email);
                }
                j++;
            }
            result.add(list);
        }
        return result;
}

    private static void dfs(Map<String, TreeSet<String>> graph,
                            String source,
                            int group,
                            Map<String, Integer> groups,
                            Set<String> visited,
                            Map<Integer, TreeSet<String>> connectedComponents) {
        visited.add(source);
        groups.put(source, group);
        if (!connectedComponents.containsKey(group)) {
            connectedComponents.put(group, new TreeSet<>());
        }
        connectedComponents.get(group).add(source);
        for (String adj : graph.get(source)) {
            if (!visited.contains(adj)) {
                dfs(graph, adj, group, groups, visited, connectedComponents);
            }
        }
    }
}
