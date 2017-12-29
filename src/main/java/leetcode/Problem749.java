package leetcode;

/**
 * https://leetcode.com/problems/shortest-completing-word/
 */
public class Problem749 {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem749 prob = new Problem749();
        System.out.println(prob.shortestCompletingWord("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"})); // steps
        System.out.println(prob.shortestCompletingWord("1s3 456", new String[]{"looks", "pest", "stew", "show"})); // pest
    }
}
