package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/all-possible-full-binary-trees/
 */
public class Problem894 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> result = new ArrayList<>();
        if (N <= 2 || N % 2 == 0) {
            return result;
        }
        allPossibleFBT(N, 1, new TreeNode(0));
        return result;
    }

    private static void allPossibleFBT(int n, int count, TreeNode node) {
        node.left = new TreeNode(0);
        node.right = new TreeNode(0);
        if (count + 2 == n) {
            System.out.println("here");
        } else {
            allPossibleFBT(n, count + 2, node.left);
            allPossibleFBT(n, count + 2, node.right);
        }
    }

    public static void main(String[] args) {
        Problem894 prob = new Problem894();
//        System.out.println(prob.allPossibleFBT(5).size()); // 2
        System.out.println(prob.allPossibleFBT(7).size()); // 5
//        System.out.println(prob.allPossibleFBT(6).size()); // 0
    }
}
