package leetcode;

/**
 * https://leetcode.com/problems/maximum-binary-string-after-change/
 */
public class Problem1702 {
    public String maximumBinaryString(String binary) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1702 prob = new Problem1702();
        System.out.println(prob.maximumBinaryString("000110")); // "111011"
        System.out.println(prob.maximumBinaryString("0000110")); // "1111011"
        System.out.println(prob.maximumBinaryString("01")); // "01"
        System.out.println(prob.maximumBinaryString("100011001010101001")); // "111111111101111111"
        System.out.println(prob.maximumBinaryString("1000111100101011101")); // "1111111101111111111"
        System.out.println(prob.maximumBinaryString("01010101010101")); // 11111101111111
        System.out.println(prob.maximumBinaryString("0101")); // 1011
        System.out.println(prob.maximumBinaryString("1111")); // 1111
        System.out.println(prob.maximumBinaryString("0000")); // 1110
    }
}

