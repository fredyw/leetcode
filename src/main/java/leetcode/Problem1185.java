package leetcode;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 * https://leetcode.com/problems/day-of-the-week/
 */
public class Problem1185 {
    public String dayOfTheWeek(int day, int month, int year) {
        LocalDate date = LocalDate.of(year, month, day);
        return date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault());
    }
}
