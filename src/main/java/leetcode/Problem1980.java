package leetcode;

/**
 * https://leetcode.com/problems/find-unique-binary-string/
 */
public class Problem1980 {
    public String findDifferentBinaryString(String[] nums) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1980 prob = new Problem1980();
        System.out.println(prob.findDifferentBinaryString(new String[]{"01","10"})); // "11"
        System.out.println(prob.findDifferentBinaryString(new String[]{"00","01"})); // "11"
        System.out.println(prob.findDifferentBinaryString(new String[]{"111","011","001"})); // "101"
    }
}
