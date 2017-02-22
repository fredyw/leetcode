package leetcode;

/**
 * https://leetcode.com/problems/detect-capital/
 */
public class Problem520 {
    public boolean detectCapitalUse(String word) {
        if (word.length() == 1) {
            return true;
        }
        boolean allLowerCase = false;
        boolean allUpperCase = false;
        boolean pascalCase = false;
        int i = 0;
        if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z' && word.charAt(i + 1) >= 'A' && word.charAt(i + 1) <= 'Z') {
            allUpperCase = true;
        } else if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z' && word.charAt(i + 1) >= 'A' && word.charAt(i + 1) <= 'z') {
            pascalCase = true;
        } else {
            allLowerCase = true;
        }
        i++;

        for (; i < word.length(); i++) {
            if (allUpperCase) {
                if (word.charAt(i) < 'A' || word.charAt(i) > 'Z') {
                    return false;
                }
            } else { // all lower case or pascal case
                if (word.charAt(i) < 'a' || word.charAt(i) > 'z') {
                    return false;
                }
            }
        }
        return true;
    }
}
