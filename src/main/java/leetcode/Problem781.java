package leetcode;

/**
 * https://leetcode.com/problems/rabbits-in-forest/
 */
public class Problem781 {
    public int numRabbits(int[] answers) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem781 prob = new Problem781();
        System.out.println(prob.numRabbits(new int[]{1, 1, 2})); // 5
        System.out.println(prob.numRabbits(new int[]{10, 10, 10})); // 11
        System.out.println(prob.numRabbits(new int[]{})); // 0
        System.out.println(prob.numRabbits(new int[]{1, 0, 1, 0, 0})); // 5
        System.out.println(prob.numRabbits(new int[]{1, 2, 3})); // 9
        System.out.println(prob.numRabbits(new int[]{1, 2, 2, 3})); // 9
        System.out.println(prob.numRabbits(new int[]{1, 2, 2, 2, 3})); // 9
        System.out.println(prob.numRabbits(new int[]{1, 2, 2, 2, 2, 3})); // 12
        System.out.println(prob.numRabbits(new int[]{1, 2, 2, 2, 2, 2, 3})); // 12
        System.out.println(prob.numRabbits(new int[]{1, 2, 2, 2, 2, 2, 2, 3})); // 15
        System.out.println(prob.numRabbits(new int[]{0})); // 1
        System.out.println(prob.numRabbits(new int[]{0, 0})); // 2
        System.out.println(prob.numRabbits(new int[]{0, 0, 0})); // 3
        System.out.println(prob.numRabbits(new int[]{0, 0, 0, 0})); // 4
    }
}
