package leetcode;

/**
 * https://leetcode.com/problems/maximum-number-of-words-you-can-type/
 */
public class Problem1935 {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] words = text.split(" ");
        int answer = 0;
        for (String word : words) {
            boolean brokenWord = false;
            for (char letter : brokenLetters.toCharArray()) {
                if (word.contains(Character.toString(letter))) {
                    brokenWord = true;
                    break;
                }
            }
            if (!brokenWord) {
                answer++;
            }
        }
        return answer;
    }
}
