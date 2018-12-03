package leetcode;

/**
 * https://leetcode.com/problems/largest-time-for-given-digits/
 */
public class Problem949 {
    public String largestTimeFromDigits(int[] A) {
        int[] count = new int[10];
        for (int a : A) {
            count[a]++;
        }
        for (int first = 2; first >= 0; first--) {
            for (int second = (first < 2) ? 9 : 3; second >= 0; second--) {
                for (int third = 5; third >= 0; third--) {
                    for (int fourth = 9; fourth >= 0; fourth--) {
                        count[first]--;
                        count[second]--;
                        count[third]--;
                        count[fourth]--;
                        if (count[first] < 0 || count[second] < 0 || count[third] < 0 ||
                            count[fourth] < 0) {
                            count[first]++;
                            count[second]++;
                            count[third]++;
                            count[fourth]++;
                        } else {
                            return String.format("%d%d:%d%d", first, second, third, fourth);                        }
                    }
                }
            }
        }
        return "";
    }
}
