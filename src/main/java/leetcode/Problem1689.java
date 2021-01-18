package leetcode;

/**
 * https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/
 */
public class Problem1689 {
    public int minPartitions(String n) {
        int answer = 0;
        for (char c : n.toCharArray()) {
            answer = Math.max(answer, c - '0');
        }
        return answer;
    }
}
