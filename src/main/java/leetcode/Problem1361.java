package leetcode;

/**
 * https://leetcode.com/problems/validate-binary-tree-nodes/
 */
public class Problem1361 {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] inCount = new int[n];
        int[] outCount = new int[n];
        for (int i = 0; i < n; i++) {
            // there should not be any edge going into the root
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
        return true;
    }

    public static void main(String[] args) {
        Problem1361 prob = new Problem1361();
//        System.out.println(prob.validateBinaryTreeNodes(4, new int[]{1,-1,3,-1}, new int[]{2,-1,-1,-1})); // true
//        System.out.println(prob.validateBinaryTreeNodes(4, new int[]{1,-1,3,-1}, new int[]{2,3,-1,-1})); // false
//        System.out.println(prob.validateBinaryTreeNodes(2, new int[]{1,0}, new int[]{-1,-1})); // false
//        System.out.println(prob.validateBinaryTreeNodes(3, new int[]{1,2,1}, new int[]{-1,-1,-1})); // false
//        System.out.println(prob.validateBinaryTreeNodes(6, new int[]{1,-1,-1,4,-1,-1}, new int[]{2,-1,-1,5,-1,-1})); // false
        System.out.println(prob.validateBinaryTreeNodes(5, new int[]{3,-1,-1,1,-1}, new int[]{4,-1,-1,2,-1})); // false
    }
}
