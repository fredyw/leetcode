package leetcode;

/**
 * https://leetcode.com/problems/sum-of-mutated-array-closest-to-target/
 */
public class Problem1300 {
    public int findBestValue(int[] arr, int target) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1300 prob = new Problem1300();
        System.out.println(prob.findBestValue(new int[]{4,9,3}, 10)); // 3
        System.out.println(prob.findBestValue(new int[]{2,3,5}, 10)); // 5
        System.out.println(prob.findBestValue(new int[]{60864,25176,27249,21296,20204}, 56803)); // 11361
    }
}
