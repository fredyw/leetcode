package leetcode;

/**
 * https://leetcode.com/problems/friends-of-appropriate-ages/
 */
public class Problem825 {
    public int numFriendRequests(int[] ages) {
        int answer = 0;
        int[] counts = new int[121]; // there are 120 ages
        for (int age : ages) {
            counts[age]++;
        }
        for (int i = 1; i < counts.length; i++) {
            for (int j = 1; j < counts.length; j++) {
                if (counts[i] > 0 && counts[j] > 0) {
                    if (reject(i, j)) {
                        continue;
                    }
                    answer += counts[i] * counts[j];
                    if (i == j) {
                        answer -= counts[i];
                    }
                }
            }
        }
        return answer;
    }

    private static boolean reject(int a, int b) {
        return ((a <= 0.5 * b + 7) || (a > b) || (a > 100 && b < 100));
    }
}
