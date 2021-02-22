package leetcode;

/**
 * https://leetcode.com/problems/longest-nice-substring/
 */
public class Problem1763 {
    public String longestNiceSubstring(String s) {
        String answer = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                String sub = s.substring(i, j + 1);
                if (isNice(sub)) {
                    if (sub.length() > answer.length()) {
                        answer = sub;
                    }
                }
            }
        }
        return answer;
    }

    private static boolean isNice(String s) {
        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                upper[c - 'A'] = true;
            } else {
                lower[c - 'a'] = true;
            }
        }
        for (char c : s.toCharArray()) {
            if ((Character.isUpperCase(c) && !lower[c - 'A']) ||
                (Character.isLowerCase(c) && !upper[c - 'a'])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Problem1763 prob = new Problem1763();
        System.out.println(prob.longestNiceSubstring("YazaAay")); // "aAa"
        System.out.println(prob.longestNiceSubstring("Bb")); // "Bb"
        System.out.println(prob.longestNiceSubstring("c")); // ""
        System.out.println(prob.longestNiceSubstring("dDzeE")); // "dD"
        System.out.println(prob.longestNiceSubstring("aBbA")); // "aBbA"
        System.out.println(prob.longestNiceSubstring("aBbAa")); // "aBbAa"
    }
}
