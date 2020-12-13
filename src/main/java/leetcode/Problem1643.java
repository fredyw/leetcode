package leetcode;

/**
 * https://leetcode.com/problems/minimum-deletions-to-make-string-balanced/
 */
public class Problem1643 {
    public int minimumDeletions(String s) {
        int countA = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                countA++;
            }
        }
        int answer = countA;
        int countB = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                countA--;
            } else {
                countB++;
            }
            if (countA + countB < answer) {
                answer = countA + countB;
            }
        }
        return answer;
    }
}
