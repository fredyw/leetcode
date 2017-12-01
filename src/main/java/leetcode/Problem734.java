package leetcode;

/**
 * https://leetcode.com/problems/sentence-similarity/
 */
public class Problem734 {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem734 prob = new Problem734();
        System.out.println(prob.areSentencesSimilar(
            new String[]{"great", "acting", "skills"},
            new String[]{"fine","drama","talent"},
            new String[][]{{"great", "fine"}, {"acting","drama"}, {"skills","talent"}}
        ));
    }
}
