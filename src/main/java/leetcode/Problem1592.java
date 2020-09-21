package leetcode;

/**
 * https://leetcode.com/problems/rearrange-spaces-between-words/
 */
public class Problem1592 {
    public String reorderSpaces(String text) {
        int totalSpaces = 0;
        for (char c : text.toCharArray()) {
            if (c == ' ') {
                totalSpaces++;
            }
        }
        String[] words = text.trim().split("\\s+");
        int spaces = words.length - 1 > 0 ? totalSpaces / (words.length - 1) : 0;
        int extraSpaces = words.length - 1 > 0 ? totalSpaces % (words.length - 1) : totalSpaces;
        StringBuilder answer = new StringBuilder();
        for (String word : words) {
            if (answer.length() == 0) {
                answer.append(word);
            } else {
                answer.append(" ".repeat(spaces)).append(word);
            }
        }
        answer.append(" ".repeat(extraSpaces));
        return answer.toString();
    }
}
