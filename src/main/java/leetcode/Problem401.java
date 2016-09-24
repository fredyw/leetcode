package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/binary-watch/
 */
public class Problem401 {
    public List<String> readBinaryWatch(int num) {
        if (num == 0) {
            return Arrays.asList("0:00");
        }
        int[] hours = new int[]{1, 2, 4, 8};
        int[] minutes = new int[]{1, 2, 4, 8, 16, 32};

        Set<String> result = new HashSet<>();
        for (int count = 0; count <= num; count++) {
            int hourCount = count;
            int minCount = num - hourCount;
            for (int hour = 0; hour < hours.length; hour++) {
                Set<Integer> hourResult = new HashSet<>();
                readBinaryWatchHour(hourCount, hours, hour, 0, hourResult);
                for (int min = 0; min < minutes.length; min++) {
                    Set<Integer> minuteResult = new HashSet<>();
                    readBinaryWatchMinute(minCount, minutes, min, 0, minuteResult);
                    for (int h : hourResult) {
                        for (int m : minuteResult) {
                            if (h == 0 && m == 0) {
                                continue;
                            }
                            result.add(String.format("%d:%02d", h, m));
                        }
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }

    private void readBinaryWatchHour(int num, int[] hours, int idx, int accu,
                                     Set<Integer> result) {
        if (accu > 11) {
            return;
        }
        if (num == 0) {
            result.add(accu);
            return;
        }
        for (int i = idx; i < hours.length; i++) {
            readBinaryWatchHour(num - 1, hours, i + 1, accu + hours[i], result);
        }
    }

    private void readBinaryWatchMinute(int num, int[] minutes, int idx, int accu,
                                       Set<Integer> result) {
        if (accu > 59) {
            return;
        }
        if (num == 0) {
            result.add(accu);
            return;
        }
        for (int i = idx; i < minutes.length; i++) {
            readBinaryWatchMinute(num - 1, minutes, i + 1, accu + minutes[i], result);
        }
    }
}
