package leetcode;

/**
 * https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/
 */
public class Problem1415 {
    public String getHappyString(int n, int k) {
        Ref<String> answer = new Ref<>("");
        getHappyString(n, new char[]{'a', 'b', 'c'}, -1, "", new Ref<>(k), answer);
        return answer.val;
    }

    private static class Ref<T> {
        private T val;

        public Ref(T val) {
            this.val = val;
        }
    }

    private static boolean getHappyString(int n,
                                          char[] chars,
                                          int prevIdx,
                                          String acc,
                                          Ref<Integer> count,
                                          Ref<String> answer) {
        if (n == 0) {
            count.val--;
            if (count.val == 0) {
                answer.val = acc;
                return true; // done
            }
            return false; // keep going
        }
        for (int i = 0; i < chars.length; i++) {
            if (prevIdx != -1 && chars[i] == chars[prevIdx]) {
                continue;
            }
            if (getHappyString(n - 1, chars, i, acc + chars[i], count, answer)) {
                return true; // done
            }
        }
        return false; // keep going
    }
}
