package leetcode;

public class Problem1688 {
    public int numberOfMatches(int n) {
        int answer = 0;
        int winner = n;
        while (winner >= 2) {
            int matches;
            if (winner % 2 == 0) {
                matches = winner / 2;
            } else {
                matches = (winner - 1) / 2;
            }
            winner -= matches;
            answer += matches;
        }
        return answer;
    }
}
