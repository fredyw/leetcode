package leetcode;

/**
 * https://leetcode.com/problems/rotated-digits/
 */
public class Problem788 {
    public int rotatedDigits(int N) {
        int result = 0;
        for (int i = 1; i <= N; i++) {
            boolean found = true;
            boolean rotatedToEachOther = false;
            for (char c : ("" + i).toCharArray()) {
                if (canRotate(c)) {
                    if (isRotatedToEachOther(c)) {
                        rotatedToEachOther = true;
                    }
                    found = true;
                } else {
                    found = false;
                    break;
                }
            }
            if (found && rotatedToEachOther) {
                result++;
            }
        }
        return result;
    }

    private static boolean canRotate(char c) {
        return c == '0' || c == '1' || c == '2' || c == '5' || c == '6' || c == '8' || c == '9';
    }

    private static boolean isRotatedToEachOther(char c) {
        return c == '2' || c == '5' || c == '6' || c == '9';
    }
}
