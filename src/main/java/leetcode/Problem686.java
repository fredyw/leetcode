package leetcode;

/**
 * https://leetcode.com/problems/repeated-string-match/
 */
public class Problem686 {
    public int repeatedStringMatch(String A, String B) {
        String a = A;
        int count = 1;
        do {
            if (a.toString().contains(B)) {
                return count;
            }
            a += A;
            count++;

        } while (a.length() <= B.length());
        if (a.toString().contains(B)) {
            return count;
        }
        return -1;
    }
}
