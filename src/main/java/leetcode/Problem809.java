package leetcode;

/**
 * https://leetcode.com/problems/expressive-words/
 */
public class Problem809 {
    public int expressiveWords(String S, String[] words) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem809 prob = new Problem809();
        System.out.println(prob.expressiveWords("heeellooo", new String[]{"hello", "hi", "helo"})); // 1
        System.out.println(prob.expressiveWords("heeellooo", new String[]{"heeellooo", "hi", "helo"})); // 1
        System.out.println(prob.expressiveWords("hello", new String[]{"hello"})); // 1
    }
}
