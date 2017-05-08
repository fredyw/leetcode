package leetcode;

/**
 * https://leetcode.com/problems/student-attendance-record-i/
 */
public class Problem551 {
    public boolean checkRecord(String s) {
        int countA = 0;
        int countL = 0;
        char c = ' ';
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                countA++;
            } else if (s.charAt(i) == 'L') {
                if (c == s.charAt(i)) {
                    countL++;
                } else {
                    countL = 1;
                }
            }
            c = s.charAt(i);
            if (countA >= 2 || countL >= 3) {
                return false;
            }
        }
        return true;
    }
}
