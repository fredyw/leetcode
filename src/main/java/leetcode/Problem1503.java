package leetcode;

/**
 * https://leetcode.com/problems/last-moment-before-all-ants-fall-out-of-a-plank/
 */
public class Problem1503 {
    public int getLastMoment(int n, int[] left, int[] right) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1503 prob = new Problem1503();
        System.out.println(prob.getLastMoment(4, new int[]{4,3}, new int[]{0,1})); // 4
        System.out.println(prob.getLastMoment(7, new int[]{}, new int[]{0,1,2,3,4,5,6,7})); // 7
        System.out.println(prob.getLastMoment(7, new int[]{0,1,2,3,4,5,6,7}, new int[]{})); // 7
        System.out.println(prob.getLastMoment(9, new int[]{5}, new int[]{4})); // 5
        System.out.println(prob.getLastMoment(6, new int[]{6}, new int[]{0})); // 6
    }
}
