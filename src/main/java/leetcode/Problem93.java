package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/restore-ip-addresses/
 */
public class Problem93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        restoreIpAddresses(s, "", 0, 1, result);
        return result;
    }

    public void restoreIpAddresses(String s, String accu, int nLength, int nSegment,
                                   List<String> result) {
        if (nSegment == 5) {
            result.add(accu);
            return;
        }
        for (int i = 1; i <= 3; i++) {
            int min = (4 - nSegment);
            int max = (4 - nSegment) * 3;
            int j = s.length() - nLength - i;
            // must be between min <= j <= max
            if (!(min <= j && j <= max)) {
                continue;
            }
            String substr = s.substring(nLength, nLength + i);
            if (substr.startsWith("0") && substr.length() >= 2) {
                continue;
            }
            int val = Integer.parseInt(substr);
            if (val > 255) {
                continue;
            }
            String newAccu = (accu.isEmpty()) ? Integer.toString(val) : accu + "." + val;
            restoreIpAddresses(s, newAccu, nLength + i, nSegment + 1, result);
        }
    }
}
