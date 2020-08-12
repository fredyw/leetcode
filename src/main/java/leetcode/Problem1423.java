package leetcode;

/**
 * https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
 */
public class Problem1423 {
    public int maxScore(int[] cardPoints, int k) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1423 prob = new Problem1423();
        System.out.println(prob.maxScore(new int[]{1,2,3,4,5,6,1}, 3)); // 12
        System.out.println(prob.maxScore(new int[]{2,2,2}, 2)); // 4
        System.out.println(prob.maxScore(new int[]{9,7,7,9,7,7,9}, 7)); // 55
        System.out.println(prob.maxScore(new int[]{1,1000,1}, 1)); // 1
        System.out.println(prob.maxScore(new int[]{1,79,80,1,1,1,200,1}, 3)); // 202
    }
}
