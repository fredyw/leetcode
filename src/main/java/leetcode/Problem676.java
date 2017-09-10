package leetcode;

/**
 * https://leetcode.com/problems/implement-magic-dictionary/
 */
public class Problem676 {
    static class MagicDictionary {

        /** Initialize your data structure here. */
        public MagicDictionary() {
            // TODO
        }

        /** Build a dictionary through a list of words */
        public void buildDict(String[] dict) {
            // TODO
        }

        /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
        public boolean search(String word) {
            // TODO
            return false;
        }
    }

    public static void main(String[] args) {
        MagicDictionary dict = new MagicDictionary();
        dict.buildDict(new String[]{"hello", "leetcode"});
        dict.search("hello"); // false
        dict.search("hhllo"); // true
        dict.search("hell"); // false
        dict.search("leetcode"); // false
    }
}
