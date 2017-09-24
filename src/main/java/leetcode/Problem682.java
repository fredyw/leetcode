package leetcode;

/**
 * https://leetcode.com/problems/baseball-game/
 */
public class Problem682 {
    public int calPoints(String[] ops) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem682 prob = new Problem682();
        System.out.println(prob.calPoints(new String[]{"5", "2", "C", "D", "+"})); // 15
        System.out.println(prob.calPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"})); // 27
    }
}
