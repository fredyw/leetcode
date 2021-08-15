package leetcode;

/**
 * https://leetcode.com/problems/number-of-strings-that-appear-as-substrings-in-word/
 */
public class Problem1967 {
    public int numOfStrings(String[] patterns, String word) {
        int answer = 0;
        for (String pattern : patterns) {
            if (word.contains(pattern)) {
                answer++;
            }
        }
        return answer;
    }
}
