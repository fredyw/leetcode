package leetcode;

/**
 * https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/
 */
public class Problem1130 {
    public int mctFromLeafValues(int[] arr) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1130 prob = new Problem1130();
        System.out.println(prob.mctFromLeafValues(new int[]{6, 2, 4})); // 32
        System.out.println(prob.mctFromLeafValues(new int[]{6, 2, 4, 5})); // 58
        System.out.println(prob.mctFromLeafValues(new int[]{6, 2})); // 12
        System.out.println(prob.mctFromLeafValues(new int[]{6, 2, 4, 1, 7})); // 78
    }
}
