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
        // In the worst case, delete all As, so this is the initial value.
        // (not the optimal answer obviously).
        int answer = countA;
        int countB = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                // countA-- here means we want to keep A at this position, but delete
                // all other As after this position (to the right).
                countA--;
            } else {
                // countB++ here means B we want to delete at this position.
                countB++;
            }
            // countA + countB here means As that we didn't delete + Bs we have deleted
            // so far.
            // Example:
            //         a b a a a b b b
            // countA: 3 3 2 1 0 0 0 0
            // countB: 0 1 1 1 1 2 3 4
            // ----------------------- +
            // answer: 3 4 3 2 1 2 3 4 --> get the min, i.e. 1
            answer = Math.min(answer, countA + countB);
        }
        return answer;
    }
}
