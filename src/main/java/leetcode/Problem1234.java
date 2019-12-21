package leetcode;

/**
 * https://leetcode.com/problems/replace-the-substring-for-balanced-string/
 */
public class Problem1234 {
    public int balancedString(String s) {
        int q = 0;
        int w = 0;
        int e = 0;
        int r = 0;
        for (char c : s.toCharArray()) {
            if (c == 'Q') {
                q++;
            } else if (c == 'W') {
                w++;
            } else if (c == 'E') {
                e++;
            } else {
                r++;
            }
        }
        int answer = 0;
        while (!((q == w) && (w == e) && (e == r))) {
            CharCount max = max(q, w, e, r);
            CharCount min = min(q, w, e, r);
            if (max.c == 'Q') {
                q--;
            } else if (max.c == 'W') {
                w--;
            } else if (max.c == 'E') {
                e--;
            } else {
                r--;
            }
            if (min.c == 'Q') {
                q++;
            } else if (min.c == 'W') {
                w++;
            } else if (min.c == 'E') {
                e++;
            } else {
                r++;
            }
            answer++;
        }
        return answer;
    }

    private static class CharCount {
        private final char c;
        private final int count;

        public CharCount(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }

    private static CharCount max(int q, int w, int e, int r) {
        int max = Math.max(q, Math.max(w, Math.max(e, r)));
        if (max == q) {
            return new CharCount('Q', q);
        }
        if (max == w) {
            return new CharCount('W', w);
        }
        if (max == e) {
            return new CharCount('E', e);
        }
        return new CharCount('R', r);
    }

    private static CharCount min(int q, int w, int e, int r) {
        int min = Math.min(q, Math.min(w, Math.min(e, r)));
        if (min == q) {
            return new CharCount('Q', q);
        }
        if (min == w) {
            return new CharCount('W', w);
        }
        if (min == e) {
            return new CharCount('E', e);
        }
        return new CharCount('R', r);
    }

    public static void main(String[] args) {
        Problem1234 prob = new Problem1234();
//        System.out.println(prob.balancedString("QWER")); // 0
//        System.out.println(prob.balancedString("QQWE")); // 1
//        System.out.println(prob.balancedString("QQQW")); // 2
//        System.out.println(prob.balancedString("QQQQ")); // 3
//        System.out.println(prob.balancedString("WQWRQQQW")); // 3
//        System.out.println(prob.balancedString("WWEQERQWQWWRWWERQWEQ")); // 4
        System.out.println(prob.balancedString("QQQWEEER")); // 3
    }
}
