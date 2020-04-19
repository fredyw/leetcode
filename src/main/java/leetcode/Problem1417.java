package leetcode;

/**
 * https://leetcode.com/problems/reformat-the-string/
 */
public class Problem1417 {
    public String reformat(String s) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1417 prob = new Problem1417();
        System.out.println(prob.reformat("a0b1c2")); // "0a1b2c"
        System.out.println(prob.reformat("leetcode")); // ""
        System.out.println(prob.reformat("1229857369")); // ""
        System.out.println(prob.reformat("covid2019")); // "c2o0v1i9d"
        System.out.println(prob.reformat("ab123")); // "1a2b3"
    }
}
