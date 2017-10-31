package leetcode;

/**
 * https://leetcode.com/problems/1-bit-and-2-bit-characters/
 */
public class Problem717 {
    public boolean isOneBitCharacter(int[] bits) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem717 prob = new Problem717();
        System.out.println(prob.isOneBitCharacter(new int[]{1, 0, 0})); // true
        System.out.println(prob.isOneBitCharacter(new int[]{1, 1, 1, 0})); // false
    }
}
