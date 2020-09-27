package leetcode;

/**
 * https://leetcode.com/problems/crawler-log-folder/
 */
public class Problem1598 {
    public int minOperations(String[] logs) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1598 prob = new Problem1598();
        System.out.println(prob.minOperations(new String[]{"d1/","d2/","../","d21/","./"})); // 2
        System.out.println(prob.minOperations(new String[]{"d1/","d2/","./","d3/","../","d31/"})); // 3
        System.out.println(prob.minOperations(new String[]{"d1/","../","../","../"})); // 0
    }
}
