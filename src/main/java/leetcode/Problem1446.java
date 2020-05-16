package leetcode;

/**
 * https://leetcode.com/problems/consecutive-characters/
 */
public class Problem1446 {
    public int maxPower(String s) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1446 prob = new Problem1446();
        System.out.println(prob.maxPower("leetcode")); // 2
        System.out.println(prob.maxPower("abbcccddddeeeeedcba")); // 5
        System.out.println(prob.maxPower("triplepillooooow")); // 5
        System.out.println(prob.maxPower("hooraaaaaaaaaaay")); // 11
        System.out.println(prob.maxPower("tourist")); // 1
    }
}
