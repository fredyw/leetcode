package leetcode;

/**
 * https://leetcode.com/problems/swap-for-longest-repeated-character-substring/
 */
public class Problem1156 {
    public int maxRepOpt1(String text) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1156 prob = new Problem1156();
        System.out.println(prob.maxRepOpt1("ababa")); // 3
        System.out.println(prob.maxRepOpt1("aaabaaa")); // 6
        System.out.println(prob.maxRepOpt1("aaabbaaa")); // 4
        System.out.println(prob.maxRepOpt1("aaaaa")); // 5
        System.out.println(prob.maxRepOpt1("abcdef")); // 1
    }
}
