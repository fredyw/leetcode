package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/clone-graph/
 */
public class Problem133 {
    private static class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<>();
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("UndirectedGraphNode [label=");
            builder.append(label);
            builder.append(", neighbors=");
            builder.append(neighbors);
            builder.append("]");
            return builder.toString();
        }
    };

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }
        Map<Integer, UndirectedGraphNode> copyMap = new HashMap<>();
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        copyMap.put(node.label, copy);
        Set<Integer> marked = new HashSet<>();
        dfs(node, copy, marked, copyMap);
        return copy;
    }
    
    private void dfs(UndirectedGraphNode source, UndirectedGraphNode copy,
        Set<Integer> marked, Map<Integer, UndirectedGraphNode> copyMap) {
        marked.add(source.label);
        for (UndirectedGraphNode n : source.neighbors) {
            UndirectedGraphNode nCopy = new UndirectedGraphNode(n.label);
            if (copyMap.containsKey(n.label)) {
                nCopy = copyMap.get(n.label);
            } else {
                copyMap.put(n.label, nCopy);
            }
            copy.neighbors.add(nCopy);
            if (!marked.contains(n.label)) {
                dfs(n, nCopy, marked, copyMap);
            }
        }
    }
}
