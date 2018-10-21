package leetcode;

/**
 * https://leetcode.com/problems/long-pressed-name/
 */
public class Problem925 {
    public boolean isLongPressedName(String name, String typed) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem925 prob = new Problem925();
        System.out.println(prob.isLongPressedName("alex", "aaleex")); // true
        System.out.println(prob.isLongPressedName("saeed", "ssaaedd")); // false
        System.out.println(prob.isLongPressedName("leelee", "lleeelee")); // true
        System.out.println(prob.isLongPressedName("laiden", "laiden")); // true
    }
}
