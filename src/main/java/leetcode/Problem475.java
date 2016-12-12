package leetcode;

/**
 * https://leetcode.com/problems/heaters/
 */
public class Problem475 {
    public int findRadius(int[] houses, int[] heaters) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem475 prob = new Problem475();
        System.out.println(prob.findRadius(new int[]{1, 2, 3}, new int[]{2})); // 1
        System.out.println(prob.findRadius(new int[]{1, 2, 3, 4}, new int[]{1, 4})); // 1
        System.out.println(prob.findRadius(new int[]{1, 2, 3, 4}, new int[]{1, 2})); // 2
        System.out.println(prob.findRadius(new int[]{1, 2, 3, 4}, new int[]{1, 2})); // 1
        System.out.println(prob.findRadius(new int[]{1, 2, 3}, new int[]{1})); // 2
        System.out.println(prob.findRadius(new int[]{1, 2, 3, 4, 5, 6}, new int[]{3})); // 3
        System.out.println(prob.findRadius(new int[]{1, 2, 6}, new int[]{1})); // 5
    }
}
