package leetcode;

/**
 * https://leetcode.com/problems/maximum-repeating-substring/
 */
public class Problem1668 {
    public int maxRepeating(String sequence, String word) {
        int answer = 0;
        int i = 0;
        while (i + word.length() <= sequence.length()) {
            String substring = sequence.substring(i, i + word.length());
            if (!substring.equals(word)) {
                i++;
            } else {
                int count = 1;
                i += word.length();
                while (i + word.length() <= sequence.length() && sequence.startsWith(word, i)) {
                    i += word.length();
                    count++;
                }
                answer = Math.max(answer, count);
            }
        }
        return answer;
    }
}
