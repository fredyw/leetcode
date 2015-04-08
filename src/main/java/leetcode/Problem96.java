package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/unique-binary-search-trees/
 */
public class Problem96 {
    public int numTrees(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        List<List<Integer>> p = permutation(list);
        return (n % 2 == 0) ? p.size() : p.size()-1;
        
//        Set<String> set = new HashSet<>();
//        for (List<Integer> l : p) {
//            StringBuilder sb = new StringBuilder();
//            TreeNode root = null;
//            System.out.println(l);
//            for (int i : l) {
//                root = buildBst(root, i, "C", 1, sb);
//            }
//            System.out.println(sb.toString());
//            set.add(sb.toString());
//        }
//        return set.size();
    }
    
//    private static class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//        
//        public TreeNode(int val) {
//            this.val = val;
//        }
//    }
//    
//    private TreeNode buildBst(TreeNode node, int val, String s,
//        int level, StringBuilder sb) {
//        if (node == null) {
//            sb.append(s + level);
//            return new TreeNode(val);
//        }
//        if (node.val >= val) {
//            node.left = buildBst(node.left, val, "L", level+1, sb);
//        } else {
//            node.right = buildBst(node.right, val, "R", level+1, sb);
//        }
//        return node;
//    }
    
    private List<List<Integer>> permutation(List<Integer> list) {
        List<List<Integer>> result = new ArrayList<>();
        permutation(list, new ArrayList<>(), result);
        return result;
    }
    
    private void permutation(List<Integer> input, List<Integer> accu,
        List<List<Integer>> result) {
        if (input.isEmpty()) {
            result.add(accu);
            return;
        }
        for (int i = 0; i < input.size(); i++) {
            List<Integer> newAccu = new ArrayList<>();
            for (int a : accu) {
                newAccu.add(a);
            }
            List<Integer> remainder = new ArrayList<>();
            for (int j = 0; j < input.size(); j++) {
                if (i == j) {
                    newAccu.add(input.get(i));
                } else {
                    remainder.add(input.get(j));
                }
            }
            permutation(remainder, newAccu, result);
        }
    }
    
    public static void main(String[] args) {
        Problem96 prob = new Problem96();
        System.out.println(prob.numTrees(10));
    }
}
