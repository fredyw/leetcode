package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
            neighbors = new ArrayList<UndirectedGraphNode>();
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
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        Set<Integer> marked = new HashSet<>();
        dfs(node, copy, marked);
        return copy;
    }
    
    private void dfs(UndirectedGraphNode source, UndirectedGraphNode copy, Set<Integer> marked) {
        marked.add(source.label);
        for (UndirectedGraphNode n : source.neighbors) {
            UndirectedGraphNode nCopy = new UndirectedGraphNode(n.label);
            copy.neighbors.add(nCopy);
            if (!marked.contains(n.label)) {
                UndirectedGraphNode nCopy = new UndirectedGraphNode(n.label);
                copy.neighbors.add(nCopy);
                dfs(n, nCopy, marked);
            }
        }
    }
    
    public static void main(String[] args) {
        Problem133 prob = new Problem133();
        
//        UndirectedGraphNode n0 = new UndirectedGraphNode(0);
//        UndirectedGraphNode n1 = new UndirectedGraphNode(1);
//        UndirectedGraphNode n2 = new UndirectedGraphNode(2);
//        
//        n0.neighbors.add(n1);
//        n0.neighbors.add(n2);
//        
//        n1.neighbors.add(n0);
//        n1.neighbors.add(n2);
//        
//        n2.neighbors.add(n0);
//        n2.neighbors.add(n1);
//        n2.neighbors.add(n2);
//        
//        UndirectedGraphNode cp0 = prob.cloneGraph(n0);
        
        UndirectedGraphNode n0 = new UndirectedGraphNode(0);
        n0.neighbors.add(n0);
        
        UndirectedGraphNode cp0 = prob.cloneGraph(n0);
        System.out.println(cp0.neighbors.get(0));
    }
}
