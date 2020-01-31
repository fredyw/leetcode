package leetcode;

/**
 * https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
 */
public class Problem1283 {
    public int smallestDivisor(int[] nums, int threshold) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1283 prob = new Problem1283();
        System.out.println(prob.smallestDivisor(new int[]{1, 2, 5, 9}, 6)); // 5
        System.out.println(prob.smallestDivisor(new int[]{2, 3, 5, 7, 11}, 11)); // 3
        System.out.println(prob.smallestDivisor(new int[]{19}, 5)); // 4
    }
}
