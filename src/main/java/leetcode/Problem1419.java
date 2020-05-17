package leetcode;

/**
 * https://leetcode.com/problems/minimum-number-of-frogs-croaking/
 */
public class Problem1419 {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int answer = 0;
        int cCount = 0;
        int rCount = 0;
        int oCount = 0;
        int aCount = 0;
        for (char c : croakOfFrogs.toCharArray()) {
            if (c == 'c') {
                cCount++;
            } else if (c == 'r') {
                if (cCount <= rCount) {
                    return -1;
                }
                rCount++;
            } else if (c == 'o') {
                if (rCount <= oCount) {
                    return -1;
                }
                oCount++;
            } else if (c == 'a') {
                if (oCount <= aCount) {
                    return -1;
                }
                aCount++;
            } else if (c == 'k') {
                cCount--;
                rCount--;
                oCount--;
                aCount--;
                if (cCount < 0 || rCount < 0 || oCount < 0 || aCount < 0) {
                    return -1;
                }
            }
            answer = Math.max(answer, cCount);
        }
        if (cCount != 0 || rCount != 0 || oCount != 0 || aCount != 0) {
            return -1;
        }
        return answer;
    }
}
