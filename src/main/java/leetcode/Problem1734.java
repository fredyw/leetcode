package leetcode;

/**
 * https://leetcode.com/problems/decode-xored-permutation/
 */
public class Problem1734 {
    public int[] decode(int[] encoded) {
        int a = 0;
        int n = encoded.length + 1;
        for (int i = 0; i <= n; ++i) {
            a ^= i;
            if (i < n && i % 2 == 1) {
                a ^= encoded[i];
            }
        }
        int[] answer = new int[n];
        answer[0] = a;
        for (int i = 0; i < n - 1; ++i) {
            answer[i + 1] = answer[i] ^ encoded[i];
        }
        return answer;
    }
}
