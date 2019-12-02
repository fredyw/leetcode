package leetcode;

/**
 * https://leetcode.com/problems/hexspeak/
 */
public class Problem1271 {
    public String toHexspeak(String num) {
        String hex = Long.toHexString(Long.valueOf(num)).toUpperCase()
            .replaceAll("0", "O").replaceAll("1", "I");
        for (int i = 0; i < hex.length(); i++) {
            if (hex.charAt(i) >= '2' && hex.charAt(i) < '9') {
                return "ERROR";
            }
        }
        return hex;
    }
}
