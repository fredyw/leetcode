package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/reorganize-string/
 */
public class Problem767 {
    public String reorganizeString(String S) {
        CharCount[] array = new CharCount[26];
        for (char i = 0; i < array.length; i++) {
            array[i] = new CharCount((char) (i + 'a'), 0);
        }
        for (int i = 0; i < S.length(); i++) {
            array[S.charAt(i) - 'a'].count++;
        }
        Arrays.sort(array, (a, b) -> Integer.compare(b.count, a.count));
        StringBuilder newString = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].count; j++) {
                newString.append(array[i].ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        char[] chars = newString.toString().toCharArray();
        while (j < chars.length) {
            if (chars[i] == chars[j]) {
                j++;
            } else {
                sb.append(chars[i++]).append(chars[j++]);
            }
        }
//        sb.append(chars[i]);
//        if (i + 1 < S.length() && chars[i] == chars[i + 1]) {
//            return "";
//        }
        return sb.toString();
    }

    private static class CharCount {
        private char ch;
        private int count;

        public CharCount(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }

        @Override
        public String toString() {
            return ch + " --> " + count;
        }
    }

    public static void main(String[] args) {
        Problem767 prob = new Problem767();
//        System.out.println(prob.reorganizeString("aab")); // aba
//        System.out.println(prob.reorganizeString("aaab")); //
//        System.out.println(prob.reorganizeString("aaabb")); // ababa
        System.out.println(prob.reorganizeString("aabbb")); // babab
//        System.out.println(prob.reorganizeString("aaabbb")); // ababab
    }
}
