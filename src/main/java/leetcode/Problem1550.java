package leetcode;

/**
 * https://leetcode.com/problems/three-consecutive-odds/
 */
public class Problem1550 {
    public boolean threeConsecutiveOdds(int[] arr) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem1550 prob = new Problem1550();
        System.out.println(prob.threeConsecutiveOdds(new int[]{2,6,4,1})); // false
        System.out.println(prob.threeConsecutiveOdds(new int[]{1,2,34,3,4,5,7,23,12})); // true
        System.out.println(prob.threeConsecutiveOdds(new int[]{1,2,3,4,5})); // false
    }
}
