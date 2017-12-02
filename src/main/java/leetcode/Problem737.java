package leetcode;

/**
 * https://leetcode.com/problems/sentence-similarity-ii/
 */
public class Problem737 {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem737 prob = new Problem737();
        System.out.println(prob.areSentencesSimilarTwo(
            new String[]{"great", "acting", "skills"},
            new String[]{"fine", "drama", "talent"},
            new String[][]{{"great", "good"}, {"fine", "good"}, {"acting","drama"}, {"skills","talent"}}
        )); // true
    }
}
