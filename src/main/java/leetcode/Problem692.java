package leetcode;

import java.util.List;

/**
 * https://leetcode.com/problems/top-k-frequent-words/
 */
public class Problem692 {
    public List<String> topKFrequent(String[] words, int k) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem692 prob = new Problem692();
        System.out.println(prob.topKFrequent(new String[]{
            "i", "love", "leetcode", "i", "love", "coding"}, 2)); // ["i", "love"]
        System.out.println(prob.topKFrequent(new String[]{
            "the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"
        }, 4)); // ["the", "is", "sunny", "day"]
    }
}
