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
        if (N == 1) {
            result.add(new TreeNode(0));
        } else if (N % 2 != 0) {
            for (int i = 0; i < N; i++) {
                int j = N - 1 - i;
                for (TreeNode left : allPossibleFBT(i))
                    for (TreeNode right : allPossibleFBT(j)) {
                        TreeNode node = new TreeNode(0);
                        node.left = left;
                        node.right = right;
                        result.add(node);
                    }
            }
        }
        return result;
    }
}
