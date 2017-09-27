package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/next-closest-time/
 */
public class Problem681 {
    public String nextClosestTime(String time) {
        Set<Integer> nums = new HashSet<>();
        for (int i = 0; i < time.length(); i++) {
            if (time.charAt(i) >= '0' && time.charAt(i) <= '9') {
                nums.add(time.charAt(i) - '0');
            }
        }
        int min = Integer.MAX_VALUE;
        String closestTime = "";
        for (int num1 : nums) {
            if (num1 > 2) {
                continue;
            }
            for (int num2 : nums) {
                if (num1 == 2 && num2 > 4) {
                    continue;
                }
                for (int num3 : nums) {
                    if (num3 > 5) {
                        continue;
                    }
                    for (int num4 : nums) {
                        String anotherTime = "" + num1 + num2 + ":" + num3 + num4;
                        if (time.equals(anotherTime)) {
                            continue;
                        }
                        int diff = diff(time, anotherTime);
                        if (diff < min) {
                            min = diff;
                            closestTime = anotherTime;
                        }
                    }
                }
            }
        }
        return closestTime.isEmpty() ? time : closestTime;
    }

    private static int diff(String from, String to) {
        String[] fromTime = from.split(":");
        int fromHour = Integer.parseInt(fromTime[0]);
        int fromMinute = Integer.parseInt(fromTime[1]);
        String[] toTime = to.split(":");
        int toHour = Integer.parseInt(toTime[0]);
        int toMinute = Integer.parseInt(toTime[1]);
        int fromMinutes = (fromHour * 60) + fromMinute;
        int toMinutes = (toHour * 60) + toMinute;
        if (toMinutes < fromMinutes) { // next day
            toMinutes += (24 * 60);
        }
        return toMinutes - fromMinutes;
    }
}
