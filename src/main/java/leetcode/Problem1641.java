package leetcode;

/**
 * https://leetcode.com/problems/count-sorted-vowel-strings/
 */
public class Problem1641 {
    public int countVowelStrings(int n) {
        int answer = 0;
        int nVowels = 5;
        Integer[][] memo = new Integer[n][nVowels];
        for (int i = 0; i < nVowels; i++) {
            answer += countVowelStrings(nVowels, n - 1, i, memo);
        }
        return answer;
    }

    private static int countVowelStrings(int nVowels, int n, int i, Integer[][] memo) {
        if (n == 0) {
            return 1;
        }
        if (memo[n][i] != null) {
            return memo[n][i];
        }
        int total = 0;
        for (int j = i; j < nVowels; j++) {
            total += countVowelStrings(nVowels, n - 1, j, memo);
        }
        memo[n][i] = total;
        return total;
    }
}
