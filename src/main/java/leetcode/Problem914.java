package leetcode;

/**
 * https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/
 */
public class Problem914 {
    public boolean hasGroupsSizeX(int[] deck) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem914 prob = new Problem914();
        System.out.println(prob.hasGroupsSizeX(new int[]{1, 2, 3, 4, 4, 3, 2, 1})); // true
        System.out.println(prob.hasGroupsSizeX(new int[]{1, 1, 1, 2, 2, 2, 3, 3})); // false
        System.out.println(prob.hasGroupsSizeX(new int[]{1})); // false
        System.out.println(prob.hasGroupsSizeX(new int[]{1, 1})); // true
        System.out.println(prob.hasGroupsSizeX(new int[]{1, 1, 2, 2, 2, 2})); // true
        System.out.println(prob.hasGroupsSizeX(new int[]{1, 1, 1, 2, 2, 2})); // true
    }
}
