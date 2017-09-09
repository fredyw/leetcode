package leetcode;

/**
 * https://leetcode.com/problems/maximum-swap/
 */
public class Problem670 {
    public int maximumSwap(int num) {
        String str = Integer.toString(num);
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            int j = i;
            int k = chars.length - 1;
            char max = chars[j];
            int maxIdx = chars.length;
            while (j < k) {
                if (max < chars[k]) {
                    max = chars[k];
                    maxIdx = k;
                }
                k--;
            }
            if (maxIdx != chars.length) {
                char tmp = chars[j];
                chars[j] = chars[maxIdx];
                chars[maxIdx] = tmp;
                break;
            }
        }
        return Integer.parseInt(new String(chars));
    }
}
