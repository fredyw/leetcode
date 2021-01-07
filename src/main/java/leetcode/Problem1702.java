package leetcode;

/**
 * https://leetcode.com/problems/maximum-binary-string-after-change/
 */
public class Problem1702 {
    public String maximumBinaryString(String binary) {
        StringBuilder answer = new StringBuilder("1".repeat(binary.length()));
        int zeroCount = 0;
        int oneCount = 0;
        int i = 0;
        for (; i < binary.length() && binary.charAt(i) == '1'; i++) {
            oneCount++;
        }
        for (; i < binary.length(); i++) {
            if (binary.charAt(i) == '0') {
                zeroCount++;
            }
        }
        if (oneCount < binary.length()) {
            answer.setCharAt(zeroCount + oneCount - 1, '0');
        }
        return answer.toString();
    }
}

