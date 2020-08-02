package leetcode;

/**
 * https://leetcode.com/problems/number-of-good-ways-to-split-a-string/
 */
public class Problem1525 {
    public int numSplits(String s) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1525 prob = new Problem1525();
        System.out.println(prob.numSplits("aacaba")); // 2
        System.out.println(prob.numSplits("abcd")); // 1
        System.out.println(prob.numSplits("aaaaa")); // 4
        System.out.println(prob.numSplits("acbadbaada")); // 2
    }
}
