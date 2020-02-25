package leetcode;

/**
 * https://leetcode.com/problems/validate-binary-tree-nodes/
 */
public class Problem1361 {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] inCount = new int[n];
        int[] outCount = new int[n];
        for (int i = 0; i < n; i++) {
            // There should not be any edge going into the root.
            if (leftChild[i] == 0 || rightChild[i] == 0) {
                return false;
            }
            if (leftChild[i] > 0) {
                outCount[i]++;
                inCount[leftChild[i]]++;
                if (inCount[leftChild[i]] > 1) {
                    return false;
                }
            }
            if (rightChild[i] > 0) {
                outCount[i]++;
                inCount[rightChild[i]]++;
                if (inCount[rightChild[i]] > 1) {
                    return false;
                }
            }
        }
        // Other than root, there should be exactly one edge going into every node.
        for (int i = 1; i < n; i++) {
            if (inCount[i] != 1) {
                return false;
            }
        }
        return true;
    }
}
