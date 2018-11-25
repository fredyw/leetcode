package leetcode;

/**
 * https://leetcode.com/problems/boats-to-save-people/
 */
public class Problem881 {
    public int numRescueBoats(int[] people, int limit) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem881 prob = new Problem881();
        System.out.println(prob.numRescueBoats(new int[]{1, 2}, 3)); // 1
        System.out.println(prob.numRescueBoats(new int[]{3, 2, 2, 1}, 3)); // 3
        System.out.println(prob.numRescueBoats(new int[]{3, 5, 3, 4}, 5)); // 4
        System.out.println(prob.numRescueBoats(new int[]{3, 5, 3, 4, 2}, 5)); // 4
    }
}
