package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-units-on-a-truck/
 */
public class Problem1710 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));
        int nBoxes = truckSize;
        int answer = 0;
        for (int[] boxType : boxTypes) {
            if (nBoxes - boxType[0] >= 0) {
                answer += boxType[0] * boxType[1];
                nBoxes -= boxType[0];
            } else {
                answer += nBoxes * boxType[1];
                nBoxes = 0;
            }
            if (nBoxes == 0) {
                break;
            }
        }
        return answer;
    }
}
