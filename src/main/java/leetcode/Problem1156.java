package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/swap-for-longest-repeated-character-substring/
 */
public class Problem1156 {
    public int maxRepOpt1(String text) {
        int[][] rightCounts = new int[text.length()][26];
        int[][] leftCounts = new int[text.length()][26];
        for (int i = text.length() - 1, j = 0; i >= 0; i--, j++) {
            int[] forwardArray = (i < text.length() - 1) ? Arrays.copyOf(rightCounts[i + 1], 26) : new int[26];
            forwardArray[text.charAt(i) - 'a']++;
            rightCounts[i] = forwardArray;

            int[] backwardArray = (j > 0) ? Arrays.copyOf(leftCounts[j - 1], 26) : new int[26];
            backwardArray[text.charAt(j) - 'a']++;
            leftCounts[j] = backwardArray;
        }
        Set<Integer> cuts = new HashSet<>();
        for (int i = 0; i < text.length() - 1; i++) {
            if (text.charAt(i) != text.charAt(i + 1)) {
                cuts.add(i);
                cuts.add(i + 1);
            }
        }
        if (cuts.isEmpty()) {
            return text.length();
        }
        int answer = 0;
        for (int cut : cuts) {
            SwapType type = SwapType.NONE;
            int length = 1;
            int i = cut;
            char current = text.charAt(i);
            while (i < text.length() - 1) {
                if (current == ' ') {
                    current = text.charAt(i);
                }
                char next = text.charAt(i + 1);
                if (current != next) {
                    // Check if it's swappable and there is a character to swap.
                    int leftCount = i - 1 >= 0 ? leftCounts[i - 1][current - 'a'] : 0;
                    int rightCount = rightCounts[i + 1][current - 'a'];
                    if (type != SwapType.NONE || (leftCount == 0 && rightCount == 0)) {
                        break;
                    }
                    type = leftCount > 0 ? SwapType.LEFT : SwapType.RIGHT;
                } else {
                    if (type == SwapType.RIGHT && rightCounts[i + 1][current - 'a'] == 1) {
                        break;
                    }
                    current = ' ';
                }
                i++;
                length++;
            }
            answer = Math.max(answer, length);
        }
        return answer;
    }

    private enum SwapType {
        NONE, LEFT, RIGHT
    }

    public static void main(String[] args) {
        Problem1156 prob = new Problem1156();
        System.out.println(prob.maxRepOpt1("ababa")); // 3
        System.out.println(prob.maxRepOpt1("aaabaaa")); // 6
        System.out.println(prob.maxRepOpt1("aaabbaaa")); // 4
        System.out.println(prob.maxRepOpt1("aaabaaaca")); // 7
        System.out.println(prob.maxRepOpt1("aaaaa")); // 5
        System.out.println(prob.maxRepOpt1("abcdef")); // 1
        System.out.println(prob.maxRepOpt1("abcdefa")); // 2
        System.out.println(prob.maxRepOpt1("abcaaa")); // 3
        System.out.println(prob.maxRepOpt1("aaa")); // 3
        System.out.println(prob.maxRepOpt1("bbababaaaa")); // 6
    }
}
