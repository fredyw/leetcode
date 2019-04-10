package leetcode;

import java.util.List;

/**
 * https://leetcode.com/problems/word-search-ii/
 */
public class Problem212 {
    public List<String> findWords(char[][] board, String[] words) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem212 prob = new Problem212();
        System.out.println(prob.findWords(new char[][]{
            {'o', 'a', 'a', 'n'},
            {'e', 't', 'a', 'e'},
            {'i', 'h', 'k', 'r'},
            {'i', 'f', 'l', 'v'}
        }, new String[]{"oath", "pea", "eat", "rain"})); // ["eat","oath"]
    }
}
