package leetcode;

/**
 * https://leetcode.com/problems/validate-binary-tree-nodes/
 */
public class Problem1361 {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem1361 prob = new Problem1361();
        System.out.println(prob.validateBinaryTreeNodes(4, new int[]{1,-1,3,-1}, new int[]{2,-1,-1,-1})); // true
        System.out.println(prob.validateBinaryTreeNodes(4, new int[]{1,-1,3,-1}, new int[]{2,3,-1,-1})); // false
        System.out.println(prob.validateBinaryTreeNodes(2, new int[]{1,0}, new int[]{-1,-1})); // false
        System.out.println(prob.validateBinaryTreeNodes(6, new int[]{1,-1,-1,4,-1,-1}, new int[]{2,-1,-1,5,-1,-1})); // false
    }
}
