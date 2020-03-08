package leetcode;

/**
 * https://leetcode.com/problems/increasing-decreasing-string/
 */
public class Problem1370 {
    public String sortString(String s) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1370 prob = new Problem1370();
        System.out.println(prob.sortString("aaaabbbbcccc")); // "abccbaabccba"
        System.out.println(prob.sortString("rat")); // "art"
        System.out.println(prob.sortString("leetcode")); // "cdelotee"
        System.out.println(prob.sortString("ggggggg")); // "ggggggg"
        System.out.println(prob.sortString("ggggggg")); // "ggggggg"
        System.out.println(prob.sortString("spo")); // "ops"
    }
}
