package leetcode;

/**
 * https://leetcode.com/problems/merge-triplets-to-form-target-triplet/
 */
public class Problem1899 {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem1899 prob = new Problem1899();
        System.out.println(prob.mergeTriplets(new int[][]{
            {2,5,3},
            {1,8,4},
            {1,7,5}
        }, new int[]{2,7,5})); // true
        System.out.println(prob.mergeTriplets(new int[][]{
            {1,3,4},
            {2,5,8}
        }, new int[]{2,5,8})); // true
        System.out.println(prob.mergeTriplets(new int[][]{
            {2,5,3},
            {2,3,4},
            {1,2,5},
            {5,2,3}
        }, new int[]{5,5,5})); // true
        System.out.println(prob.mergeTriplets(new int[][]{
            {2,5,3},
            {2,3,4},
            {1,2,5},
            {5,2,3}
        }, new int[]{5,5,3})); // true
        System.out.println(prob.mergeTriplets(new int[][]{
            {2,5,3},
            {2,3,4},
            {1,2,5},
            {5,2,3}
        }, new int[]{5,3,3})); // false
        System.out.println(prob.mergeTriplets(new int[][]{
            {2,5,3},
            {2,3,4},
            {1,2,5},
            {5,2,3}
        }, new int[]{1,5,3})); // false
        System.out.println(prob.mergeTriplets(new int[][]{
            {2,5,3},
            {2,3,4},
            {1,2,5},
            {5,2,3}
        }, new int[]{2,2,3})); // false
        System.out.println(prob.mergeTriplets(new int[][]{
            {2,5,3},
            {2,3,4},
            {1,2,5},
            {5,2,3}
        }, new int[]{2,3,3})); // false
        System.out.println(prob.mergeTriplets(new int[][]{
            {3,4,5},
            {4,5,6}
        }, new int[]{3,2,5})); // false
    }
}
