package leetcode;

/**
 * https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/
 */
public class Problem1160 {
    public int countCharacters(String[] words, String chars) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1160 prob = new Problem1160();
        System.out.println(prob.countCharacters(new String[]{"cat","bt","hat","tree"}, "atach")); // 6
        System.out.println(prob.countCharacters(new String[]{"hello","world","leetcode"}, "welldonehoneyr")); // 10
    }
}
