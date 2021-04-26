package leetcode;

/**
 * https://leetcode.com/problems/sum-of-digits-in-base-k/
 */
public class Problem1837 {
    public int sumBase(int n, int k) {
        String s = Integer.toString(n, k);
        int answer = 0;
        for (char c : s.toCharArray()) {
            answer += (c - '0');
        }
        return answer;
    }
}
