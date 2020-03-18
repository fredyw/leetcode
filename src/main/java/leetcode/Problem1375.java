package leetcode;

/**
 * https://leetcode.com/problems/bulb-switcher-iii/
 */
public class Problem1375 {
    public int numTimesAllBlue(int[] light) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1375 prob = new Problem1375();
        System.out.println(prob.numTimesAllBlue(new int[]{2,1,3,5,4})); // 3
        System.out.println(prob.numTimesAllBlue(new int[]{3,2,4,1,5})); // 2
        System.out.println(prob.numTimesAllBlue(new int[]{4,1,2,3})); // 1
        System.out.println(prob.numTimesAllBlue(new int[]{2,1,4,3,6,5})); // 3
        System.out.println(prob.numTimesAllBlue(new int[]{1,2,3,4,5,6})); // 6
    }
}
