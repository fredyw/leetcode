package leetcode;

/**
 * https://leetcode.com/problems/permutation-in-string/
 */
public class Problem567 {
    public boolean checkInclusion(String s1, String s2) {
        return checkInclusion(s1.toCharArray(), 0, s1.length() - 1, s2);
    }

    private static void swap(char[] chars, int i, int j) {
        if (j >= chars.length) {
            return;
        }
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    private static boolean checkInclusion(char[] chars, int left, int right, String string) {
        if (left == right) {
            if (string.contains(new String(chars))) {
                return true;
            }
        }
        boolean found = false;
        for (int i = left; i <= right; i++) {
            swap(chars, left, i);
            found |= checkInclusion(chars, left + 1, right, string);
            if (found) {
                return found;
            }
            swap(chars, left, i);
        }
        return found;
    }

    public static void main(String[] args) {
        Problem567 prob = new Problem567();
        System.out.println(prob.checkInclusion("ab", "eidbaooo")); // true
        System.out.println(prob.checkInclusion("ab", "eidboaoo")); // false
        System.out.println(prob.checkInclusion("dinitrophenylhydrazine", "acetylphenylhydrazine")); // false
    }
}
