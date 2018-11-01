package leetcode;

/**
 * https://leetcode.com/problems/koko-eating-bananas/
 */
public class Problem875 {
    public int minEatingSpeed(int[] piles, int H) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem875 prob = new Problem875();
        System.out.println(prob.minEatingSpeed(new int[]{3, 6, 7, 11}, 4)); // 11
        System.out.println(prob.minEatingSpeed(new int[]{3, 6, 7, 11}, 5)); // 7
        System.out.println(prob.minEatingSpeed(new int[]{3, 6, 7, 11}, 6)); // 6
        System.out.println(prob.minEatingSpeed(new int[]{3, 6, 7, 11}, 7)); // 6
        System.out.println(prob.minEatingSpeed(new int[]{3, 6, 7, 11}, 8)); // 4
        System.out.println(prob.minEatingSpeed(new int[]{3, 6, 7, 11}, 100)); // 1
        System.out.println(prob.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5)); // 30
        System.out.println(prob.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6)); // 23
    }
}
