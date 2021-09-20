package leetcode;

/**
 * https://leetcode.com/problems/final-value-of-variable-after-performing-operations/
 */
public class Problem2011 {
    public int finalValueAfterOperations(String[] operations) {
        int answer = 0;
        for (String operation : operations) {
            if (operation.equals("--X") || operation.equals("X--")) {
                answer--;
            } else {
                answer++;
            }
        }
        return answer;
    }
}
