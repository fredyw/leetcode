package leetcode;

/**
 * https://leetcode.com/problems/minimum-number-of-frogs-croaking/
 */
public class Problem1419 {
    public int minNumberOfFrogs(String croakOfFrogs) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1419 prob = new Problem1419();
        System.out.println(prob.minNumberOfFrogs("croakcroak")); // 1
        System.out.println(prob.minNumberOfFrogs("crcoakroak")); // 2
        System.out.println(prob.minNumberOfFrogs("croakcrook")); // -1
        System.out.println(prob.minNumberOfFrogs("croakcroa")); // -1
    }
}
