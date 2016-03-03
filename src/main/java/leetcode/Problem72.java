package leetcode;

/**
 * https://leetcode.com/problems/edit-distance/
 */
public class Problem72 {
    public int minDistance(String word1, String word2) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem72 prob = new Problem72();
        System.out.println(prob.minDistance("geek", "gesek")); // 1
        System.out.println(prob.minDistance("cat", "cut")); // 1
        System.out.println(prob.minDistance("sunday", "saturday")); // 3
    }
}
