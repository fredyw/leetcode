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
        // TODO
        return result;
    }

    public static void main(String[] args) {
        Problem894 prob = new Problem894();
        System.out.println(prob.allPossibleFBT(7)); // [[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
        System.out.println(prob.allPossibleFBT(6)); // []
    }
}
