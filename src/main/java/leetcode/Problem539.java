package leetcode;

import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/minimum-time-difference/
 */
public class Problem539 {
    public int findMinDifference(List<String> timePoints) {
        // I can use some Java time library, but that feels cheating.
        Collections.sort(timePoints, (a, b) -> {
            String[] aSplit = a.split(":");
            int aHour = Integer.parseInt(aSplit[0]);
            int aMinute = Integer.parseInt(aSplit[1]);

            String[] bSplit = b.split(":");
            int bHour = Integer.parseInt(bSplit[0]);
            int bMinute = Integer.parseInt(bSplit[1]);

            int cmp = Integer.compare(aHour, bHour);
            if (cmp == 0) {
                return Integer.compare(aMinute, bMinute);
            }
            return cmp;
        });
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < timePoints.size(); i++) {
            int diff = toMinutes(timePoints.get(i)) - toMinutes(timePoints.get(i - 1));
            min = Math.min(min, diff);
        }
        int diff = toMinutes(timePoints.get(0)) + (60 * 24) - toMinutes(timePoints.get(timePoints.size() - 1));
        min = Math.min(min, diff);
        return min;
    }

    private static int toMinutes(String time) {
        String[] timeSplit = time.split(":");
        return (Integer.parseInt(timeSplit[0]) * 60) + Integer.parseInt(timeSplit[1]);
    }
}
