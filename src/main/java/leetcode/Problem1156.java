package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/swap-for-longest-repeated-character-substring/
 */
public class Problem1156 {
    public int maxRepOpt1(String text) {
        int[][] counts = new int[text.length()][26];
        for (int i = text.length() - 1; i >= 0; i--) {
            int[] newArray = (i < text.length() - 1) ? Arrays.copyOf(counts[i + 1], 26) : new int[26];
            newArray[text.charAt(i) - 'a']++;
            counts[i] = newArray;
        }
//        for (int[] c : counts) {
//            System.out.println(Arrays.toString(c));
//        }
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
//        System.out.println(cuts);
        int answer = 0;
        for (int i = 0; i < cuts.size(); i++) {
            boolean swapped = false;
            int length = 1;
            int j = i;
            char current = text.charAt(j);
            while (j < text.length() - 1) {
                if (current == ' ') {
                    current = text.charAt(j);
                }
                char next = text.charAt(j + 1);
                if (current != next) {
                    // Check if it's swappable and there is a character to swap.
                    if (swapped || counts[j + 1][current - 'a'] == 0) {
                        break;
                    }
                    swapped = true;
                    // If we swap, the next char will be the same as current char.
                } else {
                    if (swapped && counts[j + 1][current - 'a'] == 1) {
                        break;
                    }
                    current = ' ';
                }
                j++;
                length++;
            }
            answer = Math.max(answer, length);
        }
        return answer;
    }

    public static void main(String[] args) {
        Problem1156 prob = new Problem1156();
//        System.out.println(prob.maxRepOpt1("ababa")); // 3
//        System.out.println(prob.maxRepOpt1("aaabaaa")); // 6
//        System.out.println(prob.maxRepOpt1("aaabbaaa")); // 4
//        System.out.println(prob.maxRepOpt1("aaabaaaca")); // 7
//        System.out.println(prob.maxRepOpt1("aaaaa")); // 5
//        System.out.println(prob.maxRepOpt1("abcdef")); // 1
//        System.out.println(prob.maxRepOpt1("abcdefa")); // 2
//        System.out.println(prob.maxRepOpt1("abcaaa")); // 3
//        System.out.println(prob.maxRepOpt1("aaa")); // 3
        System.out.println(prob.maxRepOpt1("bbababaaaa")); // 6
    }
}
