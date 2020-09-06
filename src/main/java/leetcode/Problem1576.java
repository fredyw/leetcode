package leetcode;

/**
 * https://leetcode.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters/
 */
public class Problem1576 {
    public String modifyString(String s) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1576 prob = new Problem1576();
        System.out.println(prob.modifyString("?zs")); // "azs"
        System.out.println(prob.modifyString("ubv?w")); // "ubvaw"
        System.out.println(prob.modifyString("j?qg??b")); // "jaqgacb"
        System.out.println(prob.modifyString("??yw?ipkj?")); // "acywaipkja"
    }
}
