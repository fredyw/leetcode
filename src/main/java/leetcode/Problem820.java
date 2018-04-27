package leetcode;

/**
 * https://leetcode.com/problems/short-encoding-of-words/
 */
public class Problem820 {
    public int minimumLengthEncoding(String[] words) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem820 prob = new Problem820();
        System.out.println(prob.minimumLengthEncoding(new String[]{"time", "me", "bell"})); // 10
        System.out.println(prob.minimumLengthEncoding(new String[]{"me", "bell", "time"})); // 10
        System.out.println(prob.minimumLengthEncoding(new String[]{"me", "bell", "time", "tame"})); // 15
        System.out.println(prob.minimumLengthEncoding(new String[]{"time", "men"})); // 9
        System.out.println(prob.minimumLengthEncoding(new String[]{"time", "tim"})); // 9
        System.out.println(prob.minimumLengthEncoding(new String[]{"time", "im"})); // 8
    }
}
