package leetcode;

/**
 * https://leetcode.com/problems/push-dominoes/
 */
public class Problem838 {
    public String pushDominoes(String dominoes) {
        char[] chars = new char[dominoes.length()];
        int cur = 0;
        int prev = 0;
        while (cur < dominoes.length()) {
            chars[cur] = dominoes.charAt(cur);
            if (dominoes.charAt(cur) == 'L') {
                if (dominoes.charAt(prev) == 'R') {
                    int mid = (prev + cur) / 2;
                    int mod = (prev + cur) % 2;
                    if (mod > 0) {
                        for (int i = prev; i <= mid; i++) {
                            chars[i] = 'R';
                        }
                        for (int i = mid + 1; i <= cur; i++) {
                            chars[i] = 'L';
                        }
                    } else {
                        for (int i = prev; i < mid; i++) {
                            chars[i] = 'R';
                        }
                        for (int i = mid + 1; i <= cur; i++) {
                            chars[i] = 'L';
                        }
                    }
                } else {
                    for (int i = prev; i <= cur; i++) {
                        chars[i] = 'L';
                    }
                }
                prev = cur;
            } else if (dominoes.charAt(cur) == 'R') {
                if (dominoes.charAt(prev) == 'R') {
                    for (int i = prev; i <= cur; i++) {
                        chars[i] = 'R';
                    }
                }
                prev = cur;
            }
            cur++;
        }
        if (dominoes.charAt(prev) == 'R') {
            for (int i = prev; i < dominoes.length(); i++) {
                chars[i] = 'R';
            }
        }
        return new String(chars);
    }
}
