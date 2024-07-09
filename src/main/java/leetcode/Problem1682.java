package leetcode;

import java.util.Stack;

// https://leetcode.com/problems/design-an-expression-tree-with-evaluate-function/description/
public class Problem1682 {
    abstract class Node {
        public abstract int evaluate();
    }

    class ExpressionTree extends Node {
        private TreeNode root;

        @Override
        public int evaluate() {
            return evaluate(root);
        }

        private static int evaluate(TreeNode root) {
            var left = (root.left.isOperator()) ? evaluate(root.left) : Integer.parseInt(root.left.val);
            var right = (root.right.isOperator()) ? evaluate(root.right) : Integer.parseInt(root.right.val);
            return switch (root.val) {
                case "+" -> left + right;
                case "-" -> left - right;
                case "*" -> left * right;
                default -> left / right;
            };
        }
    }

    static class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private String val;

        TreeNode(String val) {
            this.val = val;
        }

        public boolean isOperator() {
            return val.equals("+") || val.equals("-") || val.equals("*") || val.equals("/");
        }
    }

    Node buildTree(String[] postfix) {
        ExpressionTree expressionTree = new ExpressionTree();
        Stack<TreeNode> stack = new Stack<>();
        for (String token : postfix) {
            TreeNode node = new TreeNode(token);
            expressionTree.root = node;
            if (node.isOperator()) {
                if (stack.size() >= 2) {
                    node.left = stack.pop();
                    node.right = stack.pop();
                }
            }
            stack.push(node);
        }
        return expressionTree;
    }
}
